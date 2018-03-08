/**
 * @FileName: WeChatStart.java
 * @PackageName bin
 * @Description: TODO(用一句话描述该文件做什么)
 * @author MT
 * @date 2018年2月28日 上午11:22:18
 * @version
 */

package bin;

/**
 * @ClassName: WeChatStart
 * @Description:微信接口调用初始化类(1：启动获得一次Token,2:2小时去刷新一次Token)
 * @author MT
 * @date 2018年2月28日 上午11:22:18
 */
public class WeChatStarter
{

    private static WeChatPush weChatPush;
    static
    {

        weChatPush = WeChatPush.getInstance();

    }
    /**
     * 
     * @Title: initWechat
     * @Description: 应用初始化调用
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public static void initWechat()
    {

        //WeChatPush.TOKEN = weChatPush.getAccessToken();//应用初始化第一次先调用Token
        WeChatPush.CorpID =Tools.getValue("CorpID");
        WeChatPush.Secret =Tools.getValue("Secret");
        WeChatPush.agentid =Tools.getValue("agentid");
       
        
        WeChatPush.TOKEN = weChatPush.getAccessToken();
        //weChatPush.initToken();//开启每2小时的定时器去刷新Token
    }
    /**
     * 
     * @Title: colseRefreshToken
     * @Description: 应用结束调用
     * @param     设定文件
     * @return void    返回类型
     * @throws
     */
    public static void colseRefreshToken()
    {

        //weChatPush.colseRefreshToken();//开启每2小时的定时器去刷新Token
    }

}
