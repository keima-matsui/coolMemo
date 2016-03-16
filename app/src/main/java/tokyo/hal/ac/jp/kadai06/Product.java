package tokyo.hal.ac.jp.kadai06;

/**
 * Created by keima on 15/09/11.
 */
public class Product {

    private String hinmei;
    private String tenmei;

    public Product(String tenmei, String hinmei) {
        this.tenmei = tenmei;
        this.hinmei = hinmei;
    }

    public String getHinmei() {
        return hinmei;
    }

    public void setHinmei(String hinmei) {
        this.hinmei = hinmei;
    }

    public String getTenmei() {
        return tenmei;
    }

    public void setTenmei(String tenmei) {
        this.tenmei = tenmei;
    }

    @Override
    public String toString(){

        return "品名：" + getHinmei() + "　　店名：" + getTenmei();
    }
}
