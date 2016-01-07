package nuaa.ggx.pos.frontend.web.vo.extension;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import nuaa.ggx.pos.frontend.model.TConsensus;
import nuaa.ggx.pos.frontend.model.TTagword;
import nuaa.ggx.pos.frontend.util.Constants;
import nuaa.ggx.pos.frontend.util.StringHelper;
import nuaa.ggx.pos.frontend.web.vo.ConsensusShowModel;

public class ConsensusModelExtension {

	public static ConsensusShowModel toConsensusShowModel(TConsensus tConsensus) {
		Set<TTagword> tTagwords = tConsensus.getTTagwords();
		List<String> tagwords = new ArrayList<String>();
		for (TTagword tTagword : tTagwords) {
			tagwords.add(tTagword.getWord());
		}
		String urlAnchor = "<a href=" + tConsensus.getUrl() 
						+ ">" + tConsensus.getUrl() + "</a>";
		return new ConsensusShowModel(tConsensus.getId(), tConsensus.getTitle(),urlAnchor,
				tConsensus.getFromWebsite(), Constants.YYYY_MM_DD_HH_MM_SS.format(tConsensus.getCollectTime()),
				tConsensus.getSummary(), tConsensus.getTConsensusDetail().getCmtNum(),
				tConsensus.getTConsensusDetail().getEmotionPole(), StringHelper.toStringList(",", tagwords));
	}
}
