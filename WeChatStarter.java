/**
 * @FileName: WeChatStart.java
 * @PackageName bin
 * @Description: TODO(��һ�仰�������ļ���ʲô)
 * @author MT
 * @date 2018��2��28�� ����11:22:18
 * @version
 */

package bin;

/**
 * @ClassName: WeChatStart
 * @Description:΢�Žӿڵ��ó�ʼ����(1���������һ��Token,2:2Сʱȥˢ��һ��Token)
 * @author MT
 * @date 2018��2��28�� ����11:22:18
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
     * @Description: Ӧ�ó�ʼ������
     * @param     �趨�ļ�
     * @return void    ��������
     * @throws
     */
    public static void initWechat()
    {

        //WeChatPush.TOKEN = weChatPush.getAccessToken();//Ӧ�ó�ʼ����һ���ȵ���Token
        WeChatPush.CorpID =Tools.getValue("CorpID");
        WeChatPush.Secret =Tools.getValue("Secret");
        WeChatPush.agentid =Tools.getValue("agentid");
       
        
        WeChatPush.TOKEN = weChatPush.getAccessToken();
        //weChatPush.initToken();//����ÿ2Сʱ�Ķ�ʱ��ȥˢ��Token
    }
    /**
     * 
     * @Title: colseRefreshToken
     * @Description: Ӧ�ý�������
     * @param     �趨�ļ�
     * @return void    ��������
     * @throws
     */
    public static void colseRefreshToken()
    {

        //weChatPush.colseRefreshToken();//����ÿ2Сʱ�Ķ�ʱ��ȥˢ��Token
    }

}
