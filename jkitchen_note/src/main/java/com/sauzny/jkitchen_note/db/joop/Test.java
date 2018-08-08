package com.sauzny.jkitchen_note.db.joop;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.SortField;
import org.jooq.conf.RenderKeywordStyle;
import org.jooq.conf.RenderNameStyle;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;

public class Test {

    public static void main(String[] args) {

        
        String product = "DB2";
        String db = "sample";
        String table = "TEST";
        int limit = 20;

        for(SQLDialect sQLDialect : SQLDialect.values()){
            
            try{
                Settings settings = new Settings()
                        .withExecuteWithOptimisticLocking(true)
                        .withRenderNameStyle(RenderNameStyle.QUOTED)
                        .withRenderKeywordStyle(RenderKeywordStyle.UPPER);
                DSLContext dsl = DSL.using(sQLDialect, settings);
                
                String sql  = dsl.select(DSL.field("status").as("a"),DSL.max(DSL.field("name")))
                        .from(DSL.tableByName(table)).join(DSL.tableByName(table)).on(DSL.field("select11").eq(DSL.field("select22")))
                        .join(DSL.tableByName(table)).on(DSL.field("select11").eq(DSL.field("select22")))
                        .where().and("statu = 0 and statu = 0 or statu = 0")
                        .groupBy(DSL.field("date"))
                        .having(DSL.field("select").eq(0))
                        .orderBy(DSL.field("name").desc())
                        .limit(DSL.inline(new Integer(limit))).offset(DSL.inline(0))
                        .getSQL();
                        
                        
                System.out.println(sQLDialect.toString() + " | "+ sql);
            }catch(Exception e){
                System.out.println(" -- " + sQLDialect.toString() + " | "+ e.getMessage());
            }
        }
    }
}
