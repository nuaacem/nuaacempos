package nuaa.ggx.pos.frontend.web.vo.extension;

import nuaa.ggx.pos.frontend.model.TKeyword;
import nuaa.ggx.pos.frontend.web.vo.KeywordManageModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordSelectModel;
import nuaa.ggx.pos.frontend.web.vo.KeywordShowModel;

public class KeywordModelExtension {

	public static KeywordManageModel toKeywordModel(TKeyword tKeyword) {
		return new KeywordManageModel(tKeyword.getId(),
				tKeyword.getKeyword(), tKeyword.getUpdateNum(),tKeyword.getTConsensuses().size());
	}
	
	public static KeywordSelectModel toKeywordSelectModel(TKeyword tKeyword) {
		return new KeywordSelectModel(tKeyword.getId(), tKeyword.getKeyword());
	}
	
	public static KeywordShowModel toKeywordShowModel(TKeyword tKeyword) {
		return new KeywordShowModel("/nuaacempos/observe/list?keywordId=" + tKeyword.getId(), "red", tKeyword.getKeyword());
	}
	
}
