package services.twitter

import com.danielasfregola.twitter4s.TwitterStreamingClient
import com.danielasfregola.twitter4s.entities.Tweet
import com.danielasfregola.twitter4s.entities.enums.Language
import com.danielasfregola.twitter4s.entities.streaming.StreamingMessage
import com.danielasfregola.twitter4s.http.clients.streaming.TwitterStream

import scala.concurrent.Future

/**
  * Created by szymonidas on 3/18/17.
  */
class TwitterAccess {
  val streamingClient = TwitterStreamingClient()

  def run(languages: Seq[Language.Language]): Future[TwitterStream] = streamingClient.sampleStatuses(languages = languages)(printTweetText)

  def printTweetText: PartialFunction[StreamingMessage, Unit] = {

    case tweet: Tweet => println(tweet.text)
  }

}
