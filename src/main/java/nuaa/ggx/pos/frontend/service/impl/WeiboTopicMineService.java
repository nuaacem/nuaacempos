package nuaa.ggx.pos.frontend.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import nuaa.ggx.pos.collector.soap.ICollectComment;
import nuaa.ggx.pos.frontend.model.textmodel.TextDescriptionModel;
import nuaa.ggx.pos.frontend.service.interfaces.IWeiboTopicMineService;

@Service("WeiboTopicMineService")
public class WeiboTopicMineService implements IWeiboTopicMineService{

	@Resource
	ICollectComment collectComment;
	
	@Override
	public TextDescriptionModel topicMine(String url) {
		int collectResult = collectComment.collectComment(url);
		System.out.println(collectResult);
		return null;
	}

}
