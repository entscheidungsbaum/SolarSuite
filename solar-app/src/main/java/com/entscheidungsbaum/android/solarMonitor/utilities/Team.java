package com.entscheidungsbaum.android.solarMonitor.utilities;

import java.util.Date;
import java.util.Map;


public class Team extends MapStoredEntity implements CsvDeserializable {

	public static final int TRANSFER_INTERLOCK_DAYS = 7;
	
	

	public Team(Map<String, String> map) {
		super(map);
	}
	
	public  String[] getSerializationKeys() {
		return new String[] {"id","name","countryCode","color1","color2","ai","cash","prestige","lasttransfer",
				"lasttournament","q","premium","emblem","newmessage","matches","acceptedagbdate","lasttraining","nexttraining",
				"stadiumType","stadiumSize","stadiumName","bonusCode","stars"}; // NOTE if you extend this, extens TeamAndPlace's key also
	}

	public int getId() {
		return Integer.parseInt(get("id"));
	}

	public int getQ() {
		return Integer.parseInt(get("q"));
	}
	

	public String getQStr() {
		int q = getQ();
		if(q==0) {
			return "-";
		}
		else return Integer.toString(q);
	}
	
	public String getName() {
		return get("name");
	}
	
	public boolean isAI() {
		return ("1".equals(get("ai")));
	}

	public boolean hasNewMail() {
		if (get("newmessage")==null) {
			return false;
		}
		return ("1".equals(get("newmessage")));
	}
	
	public int getPrestige() {
		return Integer.parseInt(get("prestige"));
	}

	public int getCash() {
		return Integer.parseInt(get("cash"));
	}
	
	public Date getLastTransferDate() {
		if("null".equals(get("lasttransfer")) || get("lasttransfer")==null ) {
			return null;
		} else {
			return new Date( Long.parseLong(get("lasttransfer") ) );
		}
	}
	
	public Date getLastTournamentDate() {
		if("null".equals(get("lasttournament")) || get("lasttournament")==null ) {
			return null;
		} else {
			return new Date( Long.parseLong(get("lasttournament") ) );
		}
	}
	
	public Date getAcceptedAgbDate() {
		if("null".equals(get("acceptedagbdate")) || get("acceptedagbdate")==null ) {
			return new Date(0L);
		} else {
			return new Date( Long.parseLong(get("acceptedagbdate") ) );
		}
	}
	
	public Date getLastTrainingDate() {
		if("null".equals(get("lasttraining")) || get("lasttraining")==null ) {
			return new Date(0L);
		} else {
			return new Date( Long.parseLong(get("lasttraining") ) );
		}
	}	
	
	public int getNextTraining() {
		if("null".equals(get("nexttraining")) || get("nexttraining")==null ) {
			return -1;
		} else {
			return Math.max(0,Integer.parseInt(get("nexttraining") ) );
		}
	}	
	
	@Override
	public boolean equals(Object o) {
		if(!( o instanceof Team)) {
			return false;
		}
		return (   (Team)o).getId() == getId();
	}

	/**
	 * @return
	 */
	public boolean isTransferAllowed() {
		return true;
		// as of 1.050, no more transfer interlock
//		if(isPremium()) {
//			return true;
//		}
//		if("null".equals(get("lasttransfer")) || null==get("lasttransfer")) {
//			return true;
//		}
//		return ( new Date().getTime() - Long.parseLong(get("lasttransfer") ) > TRANSFER_INTERLOCK_DAYS*24*3600*1000  );
	}
	
	public boolean isPremium() {
		if("1".equals(get("premium"))) {
			return true;
		}
		return false;
	}

	/**
	 * @return date when the next transfer is allowed (might be in the passed or now)
	 */
	public Date getTransferAllowedDate() {
		if(null==getLastTransferDate()) return new Date();
		return new Date(getLastTransferDate().getTime() + TRANSFER_INTERLOCK_DAYS*24*3600*1000);
	}

	public int getEmblemType() {
		if(get("emblem")==null) {
			return 0;
		}
		return Integer.parseInt(get("emblem"));
	}

	/**
	 * @return de or en
	 */
	public String getLanguageCode() {
		String c = get("countryCode");
		if(c==null) {
			return "en";
		}
		if("de".equalsIgnoreCase(c) || "at".equalsIgnoreCase(c) || "ch".equalsIgnoreCase(c)) {
			return c;
		}
		return "en";
	}

	public int getStars() {
		String s = get("stars");
		if(s==null) return 0; else
	    return Integer.parseInt(s);
    }
}
