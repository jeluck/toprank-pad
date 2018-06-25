
package cc.toprank.byd.common.sqlbase;

/**
 * Class description
 *
 *
 * @version        2.0.0, 2017-01-12
 * @author         David  
 */
public class SqlRewriter {

    /**
     * Method description
     *
     *
     * @param tokenizer
     * @param oldName
     * @param newName
     *
     * @return
     */
    private static String rewriteDeleteTable(SqlTokenizer tokenizer, String oldName, String newName) {
        String sql = tokenizer.getSql();

        // ����  DELETE FROM
        if (tokenizer.findToken("FROM")) {

            // ��д  DELETE �еı���Ϊ: suffix ���±�����
            StringBuilder builder = new StringBuilder();
            int           index   = 0;

            while (tokenizer.moreTokens()) {

                // ��������ʼλ��
                int    begin = tokenizer.getOffset();
                String token = tokenizer.nextToken();

                // ֻ���� FROM ... WHERE
                if (token.equalsIgnoreCase("WHERE")) {
                    break;
                }

                // ʹ�ô�Сд���еı���ƥ��
                if (token.equals(oldName)) {

                    // д���µı���, ע��  DELETE ����Ҫ����
                    builder.append(sql.substring(index, begin));
                    builder.append(newName);
                    index = tokenizer.getOffset();
                }
            }

            if (index < sql.length()) {

                // д�����Ĳ���: WHERE ...
                builder.append(sql.substring(index, sql.length()));
            }

            return builder.toString();
        }

        return sql;
    }

    /**
     * Method description
     *
     *
     * @param tokenizer
     * @param oldName
     * @param newName
     *
     * @return
     */
    private static String rewriteInsertTable(SqlTokenizer tokenizer, String oldName, String newName) {
        String sql = tokenizer.getSql();

        // ��д  INSERT ����еı���Ϊ: suffix ���±�����
        StringBuilder builder = new StringBuilder();
        int           index   = 0;

        // ����  INSERT [INTO] ... [(...)] VALUES (...)
        while (tokenizer.moreTokens()) {

            // ��������ʼλ��
            int    begin = tokenizer.getOffset();
            String token = tokenizer.nextToken();

            // ������ INTO
            if ("INTO".equalsIgnoreCase(token)) {
                continue;
            }

            // ֻ���� INSERT [INTO] ... [(...)] VALUES
            if ((token.charAt(0) == '(') || "VALUES".equalsIgnoreCase(token)) {
                break;
            }

            // ʹ�ô�Сд���еı���ƥ��
            if (token.equals(oldName)) {

                // д���µı���, ע��  INSERT ����Ҫ����
                builder.append(sql.substring(index, begin));
                builder.append(newName);
                index = tokenizer.getOffset();
            }
        }

        // ����  INSERT [INTO] ... [(...)] SELECT ... FROM ... WHERE ...
        if (tokenizer.findToken("FROM")) {

            // ��д  SELETE �еı���Ϊ: suffix ���±�����
            while (tokenizer.moreTokens()) {

                // ��������ʼλ��
                int    begin = tokenizer.getOffset();
                String token = tokenizer.nextToken();

                // ֻ���� FROM ... WHERE
                if (token.equalsIgnoreCase("WHERE")) {
                    break;
                }

                // ʹ�ô�Сд���еı���ƥ��
                if (token.equals(oldName)) {

                    // �����Ľ���λ�á�
                    int     end        = tokenizer.getOffset();
                    boolean usingAlias = false;

                    // ����Ƿ������˱�ı���  TABLE [AS] ALIAS
                    if (tokenizer.moreTokens()) {
                        token = tokenizer.nextToken();

                        if (!",".equals(token)
                                &&!"WHERE".equalsIgnoreCase(token)
                                &&!"JOIN".equalsIgnoreCase(token)
                                &&!"LEFT".equalsIgnoreCase(token)
                                &&!"RIGHT".equalsIgnoreCase(token)
                                &&!"INNER".equalsIgnoreCase(token)) {

                            // ���������  AS �����������ơ�
                            usingAlias = true;
                        }

                        do {

                            // ����  JOIN ... ON ���ֵ�����
                            if (",".equals(token) || "WHERE".equalsIgnoreCase(token)) {
                                break;
                            }

                            token = tokenizer.nextToken();
                        } while (tokenizer.moreTokens());
                    }

                    // ����Ѿ���������������Ҫ���ñ���
                    builder.append(sql.substring(index, begin));
                    builder.append(newName);

                    if (!usingAlias) {

                        // ���û��������������ԭʼ������Ϊ����
                        builder.append(' ');
                        builder.append(oldName);
                    }

                    index = end;
                }
            }
        }

        if (index < sql.length()) {

            // д�����Ĳ���: SET ...WHERE ...
            builder.append(sql.substring(index, sql.length()));
        }

        if (index == 0) {

            // ������������û�и��ĵ�����
            return builder.toString().replace(oldName, newName);
        }

        return builder.toString();
    }

    /**
     * Method description
     *
     *
     * @param tokenizer
     * @param oldName
     * @param newName
     *
     * @return
     */
    private static String rewriteSelectTable(SqlTokenizer tokenizer, String oldName, String newName) {
        String sql = tokenizer.getSql();

        // ����  SELECT ... FROM
        if (tokenizer.findToken("FROM")) {

            // ��д  SELETE �еı���Ϊ: suffix ���±�����
            StringBuilder builder = new StringBuilder();
            int           index   = 0;

            while (tokenizer.moreTokens()) {

                // ��������ʼλ��
                int    begin = tokenizer.getOffset();
                String token = tokenizer.nextToken();

                // ֻ���� FROM ... WHERE
                if (token.equalsIgnoreCase("WHERE")) {
                    break;
                }

                // ʹ�ô�Сд���еı���ƥ��
                if (token.equals(oldName)) {

                    // �����Ľ���λ�á�
                    int     end        = tokenizer.getOffset();
                    boolean usingAlias = false;

                    // ����Ƿ������˱�ı���  TABLE [AS] ALIAS
                    if (tokenizer.moreTokens()) {
                        token = tokenizer.nextToken();

                        if (!",".equals(token)
                                &&!"WHERE".equalsIgnoreCase(token)
                                &&!"JOIN".equalsIgnoreCase(token)
                                &&!"LEFT".equalsIgnoreCase(token)
                                &&!"RIGHT".equalsIgnoreCase(token)
                                &&!"INNER".equalsIgnoreCase(token)) {

                            // ���������  AS �����������ơ�
                            usingAlias = true;
                        }

                        do {

                            // ����  JOIN ... ON ���ֵ�����
                            if (",".equals(token) || "WHERE".equalsIgnoreCase(token)) {
                                break;
                            }

                            token = tokenizer.nextToken();
                        } while (tokenizer.moreTokens());
                    }

                    // ����Ѿ���������������Ҫ���ñ���
                    builder.append(sql.substring(index, begin));
                    builder.append(newName);

                    if (!usingAlias) {

                        // ���û��������������ԭʼ������Ϊ����
                        builder.append(' ');
                        builder.append(oldName);
                    }

                    index = end;
                }
            }

            if (index < sql.length()) {

                // д�����Ĳ���: WHERE ...
                builder.append(sql.substring(index, sql.length()));
            }

            return builder.toString();
        }

        return sql;
    }

    /**
     * Method description
     *
     *
     * @param sql
     * @param oldName
     * @param newName
     *
     * @return
     */
    public static String rewriteSqlTable(String sql, String oldName, String newName) {
        SqlTokenizer tokenizer = new SqlTokenizer(sql);

        tokenizer.setWantedComma(true);    // ��Ҫ���ض���

        String first = tokenizer.nextToken();

        if ("SELECT".equalsIgnoreCase(first)) {

            // ��д  SELECT / DELETE ���
            return rewriteSelectTable(tokenizer, oldName, newName);
        } else if ("UPDATE".equalsIgnoreCase(first)) {

            // ��д  UPDATE ���
            return rewriteUpdateTable(tokenizer, oldName, newName);
        } else if ("INSERT".equalsIgnoreCase(first) || "REPLACE".equalsIgnoreCase(first)) {

            // ��д  INSERT / REPLACE ���
            return rewriteInsertTable(tokenizer, oldName, newName);
        } else if ("DELETE".equalsIgnoreCase(first)) {

            // ��д  DELETE ���
            return rewriteDeleteTable(tokenizer, oldName, newName);
        } else {
            sql = sql.replaceAll(oldName, newName);
        }

        return sql;    // �޷���д
    }

    /**
     * Method description
     *
     *
     * @param tokenizer
     * @param oldName
     * @param newName
     *
     * @return
     */
    private static String rewriteUpdateTable(SqlTokenizer tokenizer, String oldName, String newName) {
        String sql = tokenizer.getSql();

        // ��д  UPDATE ����еı���Ϊ: suffix ���±�����
        StringBuilder builder = new StringBuilder();
        int           index   = 0;

        // ����  UPDATE ... SET
        while (tokenizer.moreTokens()) {

            // ��������ʼλ��
            int    begin = tokenizer.getOffset();
            String token = tokenizer.nextToken();

            // ֻ���� UPDATE ... SET
            if ("SET".equalsIgnoreCase(token)) {
                break;
            }

            // ʹ�ô�Сд���еı���ƥ��
            if (token.equals(oldName)) {

                // �����Ľ���λ�á�
                int     end        = tokenizer.getOffset();
                boolean usingAlias = false;

                // ����Ƿ������˱�ı���  TABLE [AS] ALIAS
                if (tokenizer.moreTokens()) {
                    token = tokenizer.nextToken();

                    if (!",".equals(token)
                            &&!"SET".equalsIgnoreCase(token)
                            &&!"JOIN".equalsIgnoreCase(token)
                            &&!"LEFT".equalsIgnoreCase(token)
                            &&!"RIGHT".equalsIgnoreCase(token)
                            &&!"INNER".equalsIgnoreCase(token)) {

                        // ���������  AS �����������ơ�
                        usingAlias = true;
                    }

                    do {

                        // ����  JOIN ... ON ���ֵ�����
                        if (",".equals(token) || "SET".equalsIgnoreCase(token)) {
                            break;
                        }

                        token = tokenizer.nextToken();
                    } while (tokenizer.moreTokens());
                }

                // ����Ѿ���������������Ҫ���ñ���
                builder.append(sql.substring(index, begin));
                builder.append(newName);

                if (!usingAlias) {

                    // ���û��������������ԭʼ������Ϊ����
                    builder.append(' ');
                    builder.append(oldName);
                }

                index = end;
            }
        }

        if (index < sql.length()) {

            // д�����Ĳ���: SET ...WHERE ...
            builder.append(sql.substring(index, sql.length()));
        }

        return builder.toString();
    }
}



