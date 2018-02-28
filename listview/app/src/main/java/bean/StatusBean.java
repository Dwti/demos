package bean;

/**
 * Created by sunpeng on 2017/5/8.
 */

public class StatusBean extends BaseBean{
    private String desc;
    private int code;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "StatusBean{" +
                "desc='" + desc + '\'' +
                ", code=" + code +
                '}';
    }
}
