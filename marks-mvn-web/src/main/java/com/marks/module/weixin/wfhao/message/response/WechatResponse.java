/**
 * 
 */
package com.marks.module.weixin.wfhao.message.response;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import com.marks.module.weixin.event.MType;
import com.marks.module.weixin.wfhao.message.request.WechatRequest;

/**
 * 用于回复的基本消息类型
 * 
 * @author ChengNing
 * @date 2014-12-4
 */
@XmlRootElement(name = "xml")
public class WechatResponse {

	private String ToUserName;
	private String FromUserName;
	private String CreateTime;
	private String MsgType;
	private String Content;
	private String ArticleCount;

	private ImageResponse Image;
	private VoiceResponse Voice;
	private VideoResponse Video;
	private MusicResponse Music;
	private List<ArticleResponse> article;//多图文消息
	private TransInfoResponse TransInfo;//客服

	public WechatResponse(){
		
	}
	
	public WechatResponse(WechatRequest wechatRequest) {
		this.setToUserName(wechatRequest.getFromUserName());
		this.setFromUserName(wechatRequest.getToUserName());
		this.setCreateTime(wechatRequest.getCreateTime());
		this.setMsgType(MType.text.name());
	}

	public static String[] CDATA_TAG = { "ToUserName", "FromUserName", "MsgType", "Event", "MsgId", "Content",
			"MediaId", "Title", "Description", "MusicUrl", "HQMusicUrl", "ThumbMediaId", "PicUrl", "Url" };

	@XmlElement(name = "ToUserName")
	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	@XmlElement(name = "FromUserName")
	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	@XmlElement(name = "CreateTime")
	public String getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(String createTime) {
		CreateTime = createTime;
	}

	@XmlElement(name = "MsgType")
	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	@XmlElement(name = "Content")
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@XmlElement(name = "ArticleCount")
	public String getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}

	@XmlElement(name = "Image")
	public ImageResponse getImage() {
		return Image;
	}

	public void setImage(ImageResponse image) {
		Image = image;
	}

	@XmlElement(name = "Voice")
	public VoiceResponse getVoice() {
		return Voice;
	}

	public void setVoice(VoiceResponse voice) {
		Voice = voice;
	}

	@XmlElement(name = "Video")
	public VideoResponse getVideo() {
		return Video;
	}

	public void setVideo(VideoResponse video) {
		Video = video;
	}

	@XmlElement(name = "Music")
	public MusicResponse getMusic() {
		return Music;
	}

	public void setMusic(MusicResponse music) {
		Music = music;
	}

	@XmlElementWrapper(name = "Articles")
	@XmlElement(name = "item")
	public List<ArticleResponse> getArticle() {
		return article;
	}

	public void setArticle(List<ArticleResponse> article) {
		this.article = article;
	}

	@XmlElement(name = "TransInfo")
	public TransInfoResponse getTransInfo() {
		return TransInfo;
	}

	public void setTransInfo(TransInfoResponse transInfo) {
		TransInfo = transInfo;
	}
	
	/**
	 * 回复文本消息
	 * @param content 回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）
	 */
	public void responseText(String content){
		this.setMsgType(MType.text.name());
		this.setContent(content);
	}
	
	/**
	 * 回复图片消息
	 * @param mediaId 通过上传多媒体文件，得到的id
	 */
	public void responseImage(String mediaId){
        this.setMsgType(MType.image.name());
		ImageResponse image = new ImageResponse();
		image.setMediaId(mediaId);
		this.setImage(image);
	}
	
	/**
	 * 回复语音消息
	 * @param mediaId  通过上传多媒体文件，得到的id
	 */
	public void responseVoice(String mediaId){
		this.setMsgType(MType.voice.name());
		VoiceResponse voice = new VoiceResponse();
		voice.setMediaId(mediaId);
		this.setVoice(voice);
	}
	
	/**
	 * 回复视频消息
	 * @param mediaId      通过上传多媒体文件，得到的id
	 * @param title        视频消息的标题
	 * @param description  视频消息的描述
	 */
	public void responseVideo(String mediaId,String title,String description){
		VideoResponse video = new VideoResponse();
		video.setMediaId(mediaId);
		video.setTitle(title);
		video.setDescription(description);
		responseVideo(video);
	}
	
	/**
	 * 回复视频消息
	 * @param video  视频消息
	 */
	public void responseVideo(VideoResponse video){
		this.setMsgType(MType.video.name());
		this.setVideo(video);
	}
	
	/**
	 * 回复音乐消息
	 * @param title         音乐标题
	 * @param description   音乐描述
	 * @param musicURL      音乐链接
	 * @param hQMusicUrl    高质量音乐链接，WIFI环境优先使用该链接播放音乐
	 * @param thumbMediaId  缩略图的媒体id，通过上传多媒体文件，得到的id
	 */
	public void responseMusic(String title,String description,
			String musicURL,String hQMusicUrl,String thumbMediaId){
		MusicResponse music = new MusicResponse();
		music.setTitle(title);
		music.setDescription(description);
		music.setMusicURL(musicURL);
		music.setHQMusicUrl(hQMusicUrl);
		music.setThumbMediaId(thumbMediaId);
		responseMusic(music);
	}
	
	/**
	 * 回复音乐消息
	 * @param music  音乐消息
	 */
	public void responseMusic(MusicResponse music){
		this.setMsgType(MType.music.name());
		this.setMusic(music);
	}
	
	/**
	 * 回复图文消息，单条图文消息
	 * @param title         图文消息标题
	 * @param description   图文消息描述
	 * @param picUrl        图片链接，支持JPG、PNG格式，较好的效果为大图360*200，小图200*200
	 * @param url           点击图文消息跳转链接
	 */
	public void responseNew(String title,String description,String picUrl,String url){
		ArticleResponse item = new ArticleResponse();
		item.setTitle(title);
		item.setDescription(description);
		item.setPicUrl(picUrl);
		item.setUrl(url);
		responseNews(item);
	}
	
	/**
	 * 回复图文消息单条
	 * @param item
	 */
	public void responseNews(ArticleResponse item){
		List<ArticleResponse> items = new ArrayList<ArticleResponse>();
		items.add(item);
		responseNews(items);
	}
	
	/**
	 * 回复图文消息
	 * @param items
	 */
	public void responseNews(List<ArticleResponse> items){
		this.setMsgType(MType.news.name());
		this.setArticleCount(String.valueOf(items.size()));
		this.setArticle(items);
		
	}
	
	/**
	 * 消息转发到多客服
	 */
	public void responseCustomerService(){
		this.setMsgType(MType.transfer_customer_service.name());
	}
	/**
	 * 消息转发到指定客服
	 * @param kfAccount 客服账号
	 */
	public void responseCustomerService(String kfAccount){
		this.setMsgType(MType.transfer_customer_service.name());
		this.setTransInfo(new TransInfoResponse(kfAccount));
		
	}
	/**
	 * 消息转发到指定客服
	 * @param kfAccount 客服
	 */
	public void responseCustomerService(TransInfoResponse transInfo){
		this.setMsgType(MType.transfer_customer_service.name());
		this.setTransInfo(transInfo);
		
	}
	

}
