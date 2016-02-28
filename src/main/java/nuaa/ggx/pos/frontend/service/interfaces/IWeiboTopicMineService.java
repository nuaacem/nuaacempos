package nuaa.ggx.pos.frontend.service.interfaces;

import nuaa.ggx.pos.frontend.model.textmodel.TextDescriptionModel;

public interface IWeiboTopicMineService {

	/**
	 * 多媒体微博主题挖掘的业务逻辑
	 * @param url 多媒体微博url
	 * @return 多媒体微博文本描述模型
	 */
	public TextDescriptionModel topicMine(String url);
	
}
