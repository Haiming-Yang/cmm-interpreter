package app;

import antlr.CmmParser;

/**
 * Created by TangfJiong on 2016/1/2.
 * A generic programming language symbol
 */
public class Symbol {

    String name;      // All symbols at least have a name
    Type type;
    Scope scope;      // All symbols know what scope contains them.
    String typeName;  // when type is user define type this variable is a clue.

    public Symbol(String name) {
        this.name = name;
    }
    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        if ( type!=Type.tVoid ) return '<'+getName()+":"+type+'>';
        return getName();
    }

    public Type getType(){
        return type;
    }
    public void setType(Type _type){
        type = _type;
    }

}
