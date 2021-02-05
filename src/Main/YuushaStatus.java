package Main;

public class YuushaStatus {
	private static int condition = 0;
	private static boolean direction = true;//참이면 오른쪽, 거짓이면 왼쪽
	private static boolean potion = true;
	private static int hp=100;
	private static int maxHp=100;
	private static int stageHp;
	private static int stageMaxHp;
	private static int stage;
	private static int time = 0;
	private static int stageTime;
	private static boolean princessLive = true;
	public static int getHp() {
		return hp;
	}
	public static void setHp(int hp) {
		YuushaStatus.hp = hp;
	}
	public static int getMaxHp() {
		return maxHp;
	}
	public static void setMaxHp(int maxHp) {
		YuushaStatus.maxHp = maxHp;
	}
	public static int getTime() {
		return time;
	}
	public static void setTime(int time) {
		YuushaStatus.time = time;
	}
	public static int getStageTime() {
		return stageTime;
	}
	public static void setStageTime(int stageTime) {
		YuushaStatus.stageTime = stageTime;
	}
	public static boolean isPrincessLive() {
		return princessLive;
	}
	public static void setPrincessLive(boolean princessLive) {
		YuushaStatus.princessLive = princessLive;
	}
	public static int getStageHp() {
		return stageHp;
	}
	public static void setStageHp(int stageHp) {
		YuushaStatus.stageHp = stageHp;
	}
	public static int getStageMaxHp() {
		return stageMaxHp;
	}
	public static void setStageMaxHp(int stageMaxHp) {
		YuushaStatus.stageMaxHp = stageMaxHp;
	}
	public static int getStage() {
		return stage;
	}
	public static void setStage(int stage) {
		YuushaStatus.stage = stage;
	}
	public static int getCondition() {
		return condition;
	}
	public static void setCondition(int condition) {
		YuushaStatus.condition = condition;
	}
	public static boolean isDirection() {
		return direction;
	}
	public static void setDirection(boolean direction) {
		YuushaStatus.direction = direction;
	}
	public static boolean isPotion() {
		return potion;
	}
	public static void setPotion(boolean potion) {
		YuushaStatus.potion = potion;
	}
	
}
