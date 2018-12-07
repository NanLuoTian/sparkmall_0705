import org.apache.commons.configuration2.PropertiesConfiguration
import org.apache.commons.configuration2.FileBasedConfiguration
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder
import org.apache.commons.configuration2.builder.fluent.Parameters

object ConfigurantionUtil {


  def apply(propertiesName:String) = {
    val configurationUtil = new ConfigurationUtil()
    if (configurationUtil.config == null) {
      configurationUtil.config = new FileBasedConfigurationBuilder[FileBasedConfiguration](classOf[PropertiesConfiguration])
        .configure(new Parameters().properties().setFileName(propertiesName)).getConfiguration
    }
    configurationUtil
  }

  def main(args: Array[String]): Unit = {
    val config: FileBasedConfiguration = ConfigurantionUtil("config.properties").config

    println(config.getString("jdbc.user"))

  }
}


class ConfigurationUtil(){
  var config:FileBasedConfiguration=null

}
