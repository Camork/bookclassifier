package cn.camork.core;

/**
 * Created by camork on 24/12/2017.
 */
public interface IRecognize {

	String URL_REGEX="^((ht|f)tps?):\\/\\/[\\w\\-]+(\\.[\\w\\-]+)+([\\w\\-\\.,@?^=%&:\\/~\\+#]*[\\w\\-\\@?^=%&\\/~\\+#])?$";

	boolean dispose();

}
