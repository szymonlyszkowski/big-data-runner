package controllers;


import bigdata.engines.hadoop.WordCount
import play.api.mvc.{Action, Controller};

/**
 * Created by szymonidas on 4/13/17.
 */
class HadoopController extends Controller{

    def wordCount = Action {
        new WordCount().run()
        Ok("word count started")
    }


}

