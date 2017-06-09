package compsg.cn.msgboard.bean;

//Messages表的实体类
public class Messages {

    //留言id
    private int msgId;
    //留言时间
    private String msgTime;
    //留言内容
    private String msgContent;
    //留言用户
    private Users user;

    public Messages() {
        super();
    }

    public Messages(String msgContent, Users user) {
        super();
        this.msgContent = msgContent;
        this.user = user;
    }

    public int getMsgId() {
        return msgId;
    }
    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }
    public String getMsgTime() {
        return msgTime;
    }
    public void setMsgTime(String msgTime) {
        this.msgTime = msgTime;
    }
    public String getMsgContent() {
        return msgContent;
    }
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }
    public Users getUser() {
        return user;
    }
    public void setUser(Users user) {
        this.user = user;
    }
}
