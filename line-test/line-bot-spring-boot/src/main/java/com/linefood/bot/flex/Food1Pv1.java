package com.linefood.bot.flex;

import com.linecorp.bot.model.action.URIAction;
import com.linecorp.bot.model.message.FlexMessage;
import com.linecorp.bot.model.message.flex.component.*;
import com.linecorp.bot.model.message.flex.component.Button.ButtonHeight;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectMode;
import com.linecorp.bot.model.message.flex.component.Image.ImageAspectRatio;
import com.linecorp.bot.model.message.flex.container.Bubble;
import com.linecorp.bot.model.message.flex.unit.FlexFontSize;
import com.linecorp.bot.model.message.flex.unit.FlexLayout;
import com.linecorp.bot.model.message.flex.unit.FlexMarginSize;

import java.util.function.Supplier;

import static java.util.Arrays.asList;

public class Food1Pv1 implements Supplier<FlexMessage> {
    @Override
    public FlexMessage get() {
        final Image heroBlock = createHeroBlock();
        final Box bodyBlock = createBodyBlock();
        final Box footerBlock = createFooterBlock();

        final Bubble bubbleContainer = Bubble.builder()
                .hero(heroBlock)
                .body(bodyBlock)
                .footer(footerBlock)
                .build();
        return new FlexMessage("Restaurant", bubbleContainer);
    }

    private Image createHeroBlock() {
        return Image.builder()
                .url("https://img.wongnai.com/p/1920x0/2017/10/03/4c268dfc48bf48f18e0211cfc2733931.jpg")
                .size(Image.ImageSize.FULL_WIDTH)
                .aspectRatio(ImageAspectRatio.R20TO13)
                .aspectMode(ImageAspectMode.Cover)
                .action(new URIAction("label", "http://example.com"))
                .build();
    }

    private Box createBodyBlock() {
        final Text title = Text.builder()
                .text("วิธีทำข้าวซอย")
                .weight(Text.TextWeight.BOLD)
                .size(FlexFontSize.XL)
                .build();
        
        final Box info = createInfoBox();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .contents(asList(title,info))
                .build();
    }

    private Box createInfoBox() {
        final Box place = Box.builder()
                .layout(FlexLayout.BASELINE)
                .spacing(FlexMarginSize.SM)
                .contents(asList(
                        Text.builder()
                            .text("วัตถุดิบ\n1.น่องไก่ 3 น่องใหญ่\n2.น้ำพริกข้าวซอย 100 กรัม \n3.กะทิ 500 กรัม\n4.เส้นข้าวซอยหรือเส้นหมี่ไข่อิสลาม 100 กรัม \n5.น้ำมันพืช 3 ถ้วยตวง \n6.น้ำปลา 3 ช้อนโต๊ะ\n7.เกลือ 2 ช้อนชา\n8.น้ำตาลมะพร้าว 1.5 ช้อนโต๊ะ\n9.พริกผัด 1 ช้อนโต๊ะ\n10.น้ำสะอาด 1.5ลิตร\n11.หออมแขกซอย\n12.ผักกาดดองซอย\n13.ต้นหอมผักชี\nวิธีทำ\nSTEP 1:ปรุงน้ำข้าวซอย\n-ตั้งหม้อหรือกระทะใบใหญ่ให้ร้อน ใส่กะทิลงไปเคี่ยวสักพัก ตามด้วยเครื่องแกง จากนั้นเคี่ยวจนกะทิให้แตกมัน\n-ใส่น่องไก่ลงไปผัดให้เข้ากับกะทิ แล้วเติมกะทิลงไปจนหมด เคี่ยวต่อให้ไก่เปื่อย สัก 30-40 นาที\nSTEP2:ลวกเส้น + ทอดเส้นข้าวซอย\n-ลวกเส้นข้าวซอยให้นุ่มก่อนนำไปทอดค่ะ โดยเราจะนำไปลวกในน้ำเดือด โดยใช้เวลาประมาณ 8 นาที\n-โดยแบ่งเส้นข้าวซอยที่ลวกแล้วสัก 2 หยิบมือ ผึ่งให้แห้งแล้วนำลงทอดในน้ำมันปาล์มเดือด ๆ สักพักให้กรอบ แล้วตักขึ้นพักไว้ค่ะ\nSTEP 3:จัดเสริฟ\n- ตักเส้นข้าวซอยลวกลงในชาม แล้วตักน้ำข้าวซอย พร้อมน่องไก่ราดลงไป\nตกแต่งด้วยข้าวซอยทอดและต้นหอมผักชีซอย ทานพร้อมพริกผัด หอมแดงซอย และผักกาดดอง")
                            .wrap(true)
                            .color("#666666")
                            .flex(5)
                            .build()
                )).build();
        
        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .margin(FlexMarginSize.LG)
                .spacing(FlexMarginSize.SM)
                .contents(asList(place))
                .build();
    }


    private Box createFooterBlock() {
        final Spacer spacer = Spacer.builder().size(FlexMarginSize.SM).build();
        final Separator separator = Separator.builder().build();
        final Button websiteAction = Button.builder()
                .style(Button.ButtonStyle.LINK)
                .height(ButtonHeight.SMALL)
                .action(new URIAction("WEBSITE", "https://guide.michelin.com/th/th/article/features/10-northern-thai-dishes-you-should-know"))
                .build();

        return Box.builder()
                .layout(FlexLayout.VERTICAL)
                .spacing(FlexMarginSize.SM)
                .contents(asList(spacer, separator, websiteAction))
                .build();

    }
}

