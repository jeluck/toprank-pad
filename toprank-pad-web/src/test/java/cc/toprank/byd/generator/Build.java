package cc.toprank.byd.generator;


import cc.toprank.byd.infrastructure.support.tool.codegen.core.ToprankBuild;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.sql.SQLException;


public class Build {

    public static void main(String[] args) {
        ToprankBuild tb = new ToprankBuild();
        try {
            // tb.buildDictionaryCatalog("",true);
             tb.buildBaseEntity("O_ComboDetailValueMapping");
//            tb.buildEntityBaseAndEntityExt("B_MerchantTagMapping");
//            tb.buildEntityBaseAndEntityExt("B_MerchantTagInfo");

//            tb.buildDictionary("OrderManager",true);
//            tb.buildMapper("P_ProductTagInfo");
            // tb.buildDaoImpl("SystemMaxID", true);
        } catch (SQLException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }
}
