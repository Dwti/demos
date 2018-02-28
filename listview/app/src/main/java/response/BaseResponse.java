package response;


import bean.StatusBean;

/**
 * Created by srt-k12001 on 2017/12/19.
 */

public class BaseResponse  {
    protected StatusBean status;

    public StatusBean getStatus() {
        return status;
    }

    public void setStatus(StatusBean status) {
        this.status = status;
    }
}
