package app;

/**
 * Created by 3D-WorkStation on 2016/1/2.
 */
public class LocalScope extends BaseScope {

    public LocalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "locals";
    }
}
