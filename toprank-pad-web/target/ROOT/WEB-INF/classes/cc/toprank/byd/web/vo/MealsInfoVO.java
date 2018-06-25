package cc.toprank.byd.web.vo;

/**
 * @Description： 餐次信息Vo
 * @Author：HuTao
 * @Time: 2017-3-9 14:48
 * @Version 2.0.0
 * Created by HuTao on 2017-3-9.
 */
public class MealsInfoVO {
    private String mealName;
    private String startTime;
    private String endTime;
    private String duration;
    private String timeUnit;

    public String getMealName() {
        return mealName;
    }

    public void setMealName(String mealName) {
        this.mealName = mealName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTimeUnit() {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit) {
        this.timeUnit = timeUnit;
    }
}
