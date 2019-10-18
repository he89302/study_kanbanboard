package tw.teddysoft.clean.app.console.spring.config;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.shell.jline.PromptProvider;

@Configuration
public class ShellConfiguration {

  @Bean
  public PromptProvider promptProvider() {
    return () -> new AttributedString("cleanKanban> ",
        AttributedStyle.DEFAULT.foreground(AttributedStyle.BLUE));
  }
}
