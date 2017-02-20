package controllers

import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.{Action, Controller}
import views.html.{form, hello}
import play.api.Play.current
import play.api.i18n.Messages.Implicits._

/**
  * Created by szymonidas on 2/15/17.
  */
class MyFirstController extends Controller{
  def index = TODO
  def controllerMethodWithParameter(name: String) = Action {
      Ok(s"controllerMethodWithParameter invoked in MyFirstController with parameter: $name")
  }

  /**
    * Describes the hello form.
    */
  val helloForm = Form(
    tuple(
      "name" -> nonEmptyText,
      "repeat" -> number(min = 1, max = 100),
      "color" -> optional(text)
    )
  )

  def myAction = Action {
    Ok(s"index method $helloForm")
  }

//  /**
//    * Handles the form submission.
//    */
//  def sayHello = Action { implicit request =>
//    helloForm.bindFromRequest.fold(
//      formWithErrors => BadRequest(html.hello(formWithErrors)),
//      {case (name, repeat, color) => Ok(s"following params were added $name, $repeat.toInt, $color")}
//    )
//  }


  /**
    * Handles the form submission.
    */
  def sayHello = Action { implicit request =>
    helloForm.bindFromRequest.fold(
      formWithErrors => BadRequest(form(formWithErrors)),
      {case (name, repeat, color) => Ok(hello(name, repeat.toInt, color))}
    )
  }


}
