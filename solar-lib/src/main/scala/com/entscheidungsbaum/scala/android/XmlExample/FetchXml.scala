package com.entscheidungsbaum.scala.android.XmlExample
import scala.collection.mutable.Queue

object FetchXml {

  import java.net.{
    URLConnection,
    URL
  }
  import scala.xml._

  
  def getGoogleWeather():Elem={
    val url = new URL("http://www.google.com/ig/api?weather=Duisburg")
    val conn = url.openConnection
    XML.load(conn.getInputStream)
  }
  
  def parserXmlResponse(): Seq[String] = {
    val xml = getGoogleWeather
    xml \\ "forecast_information"
    
    var results =  new Queue[String]()
    
    return results
  }
}