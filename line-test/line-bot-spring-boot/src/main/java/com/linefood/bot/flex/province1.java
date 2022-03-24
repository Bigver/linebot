
//เชียงใหม่

package com.linefood.bot.flex;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.container.Carousel;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexGravity;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class province1 implements Supplier<FlexMessage> {
        @Override
        public FlexMessage get() {
        final Bubble bubble1 = createBubble("ข้าวซอย",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/427/large/01_FB.jpg?1591947409",
        false);
        final Bubble bubble2 = createBubble("น้ำเงี้ยว ",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/428/large/02_FB.jpg?1591947550",
        true);
        final Bubble bubble3 = createBubble("น้ำพริกอ่อง",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/429/large/03_FB.jpg?1591947564",
        true);
        final Bubble bubble4 = createBubble("น้ำพริกหนุ่ม",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/430/large/04_FB.jpg?1591947580",
        true);
        final Bubble bubble5 = createBubble("ไส้อั่ว",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/431/large/05_FB.jpg?1591947613",
        true);
        final Bubble bubble6 = createBubble("แกงฮังเล",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/432/large/06_FB.jpg?1591947842",
        true);
        final Bubble bubble7 = createBubble("ลาบหมูคั่ว",
        "5",
        "https://p-u.popcdn.net/attachments/images/000/026/433/large/07_FB.jpg?1591947952",
        true);
            final Bubble seeMore = createSeeMoreBubble();
            final Carousel carousel = Carousel.builder()
                    .contents(asList(bubble1, bubble2, bubble3, bubble4, bubble5, bubble6, bubble7 ,seeMore))
                    .build();
            return new FlexMessage("Catalogue", carousel);
        }
    
        private Bubble createBubble(String title, String price, String imageURL, Boolean isOutOfStock) {
            final Image heroBlock = createHeroBlock(imageURL);
            final Box bodyBlock = createBodyBlock(title, price, isOutOfStock);
            return Bubble.builder()
                    .hero(heroBlock)
                    .body(bodyBlock)
                    .build();
        }
    
        private Bubble createSeeMoreBubble() {
            return Bubble.builder()
                    .body(Box.builder()
                            .layout(FlexLayout.VERTICAL)
                            .spacing(FlexMarginSize.SM)
                            .contents(asList(
                                    Button.builder()
                                            .flex(1)
                                            .gravity(FlexGravity.CENTER)
                                            .action(new URIAction("Web site", "https://www.eventpop.me/blogs/638-7-food-chiang-mai"))
                                            .build()
                            )).build()
                    )
                    .build();
        }
    
        private Image createHeroBlock(String imageURL) {
            return Image.builder()
                    .size(Image.ImageSize.FULL_WIDTH)
                    .aspectRatio(Image.ImageAspectRatio.R20TO13)
                    .aspectMode(Image.ImageAspectMode.Cover)
                    .url(imageURL)
                    .build();
        }
    
        private Box createBodyBlock(String title, String price, Boolean isOutOfStock) {
            final Text titleBlock = Text.builder()
                    .text(title)
                    .gravity(FlexGravity.CENTER)
                    .wrap(true)
                    .weight(Text.TextWeight.BOLD)
                    .size(FlexFontSize.XL).build();
        
    
            FlexComponent[] flexComponents = {titleBlock};
            List<FlexComponent> listComponent = new ArrayList<>(Arrays.asList(flexComponents));
    
            return Box.builder()
                    .layout(FlexLayout.VERTICAL)
                    .spacing(FlexMarginSize.SM)
                    .contents(listComponent)
                    .build();
        }

    }

        