package request;

/**
 * Created by srt-k12001 on 2017/12/18.
 */

public class HomeworkRequest extends EXueELianBaseRequest{

    @Override
    protected boolean shouldLog() {
        return false;
    }

    //    public String urlSever=;
    @Override
    protected HttpType httpType() {
        return HttpType.GET;
    }

    @Override
    protected String urlServer() {
        return "mobile.hwk.yanxiu.com/app";
    }

    @Override
    protected String urlPath() {
        return "/class/listGroupPaper.do";

    }


}
