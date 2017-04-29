package services.twitter

import javax.inject.Inject

import twitter4j.conf.ConfigurationBuilder
import twitter4j.{Twitter, TwitterFactory}

/**
  * Created by szymonidas on 3/19/17.
  */
class Twitter4JConfiguration @Inject()(configuration: play.api.Configuration) {
  private val KEY = "key"
  private val SECRET = "secret"
  private val twitterConfigObject = configuration.underlying.getObject("twitter").toConfig

  private def getConsumerMap() = {
    twitterConfigObject.getObject("consumer").unwrapped
  }

  private def getAccessMap() = {
    twitterConfigObject.getObject("access").unwrapped
  }

  def getTwitter4JAccess(): Twitter = {
    val accessMap = getAccessMap
    val consumerMap = getConsumerMap
    val cb = new ConfigurationBuilder()
    cb.setDebugEnabled(true)
      .setOAuthConsumerKey(consumerMap.get(KEY).toString)
      .setOAuthConsumerSecret(consumerMap.get(SECRET).toString)
      .setOAuthAccessToken(accessMap.get(KEY).toString)
      .setOAuthAccessTokenSecret(accessMap.get(SECRET).toString)
    val tf = new TwitterFactory(cb.build())
    return tf.getInstance()
  }
}
