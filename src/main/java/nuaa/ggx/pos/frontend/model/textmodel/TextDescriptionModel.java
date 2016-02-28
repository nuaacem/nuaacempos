package nuaa.ggx.pos.frontend.model.textmodel;

import java.util.List;

public class TextDescriptionModel {

	private String contentTag;
	
	private List<String> contentKeywords;
	
	private String emotionTag = "情感";
	
	private List<String> emotionKeywords;

	public String getContentTag() {
		return contentTag;
	}

	public void setContentTag(String contentTag) {
		this.contentTag = contentTag;
	}

	public List<String> getContentKeywords() {
		return contentKeywords;
	}

	public void setContentKeywords(List<String> contentKeywords) {
		this.contentKeywords = contentKeywords;
	}

	public String getEmotionTag() {
		return emotionTag;
	}

	public void setEmotionTag(String emotionTag) {
		this.emotionTag = emotionTag;
	}

	public List<String> getEmotionKeywords() {
		return emotionKeywords;
	}

	public void setEmotionKeywords(List<String> emotionKeywords) {
		this.emotionKeywords = emotionKeywords;
	}

}
