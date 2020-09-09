package com.wts.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.kit.PropKit;
import com.wts.entity.model.Complaintletter;
import com.wts.entity.model.Filingcase;
import com.wts.service.ComplainletterService;
import com.wts.util.IDNumber;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.wts.util.WordUtil.CreatWordByModel;
import static com.wts.util.WordUtil.printWord;

public class ComplaintLetterController extends Controller {
    @Inject
    ComplainletterService complainletterService;

    public void index() {
        render("/ComplaintLetter.html");
    }

    public void i() {
        Complaintletter complaintletter = complainletterService.findFirst();
        set("id", complaintletter.get("id"))
                .set("PersonName", complaintletter.get("PersonName"))
                .set("PersonNumber", complaintletter.get("PersonNumber"))
                .set("PersonAge", complaintletter.get("PersonAge"))
                .set("PersonSex", complaintletter.get("PersonSex"))
                .set("PersonPhone", complaintletter.get("PersonPhone"))
                .set("PersonAddress", complaintletter.get("PersonAddress"))
                .set("ComplaintDate", complaintletter.get("ComplaintDate"))
                .set("CompanyName", complaintletter.get("CompanyName"))
                .set("CompanyAddress", complaintletter.get("CompanyAddress"))
                .set("LegalName", complaintletter.get("LegalName"))
                .set("LegalPosition", complaintletter.get("LegalPosition"))
                .set("LegalPhone", complaintletter.get("LegalPhone"))
                .set("PersonnelName", complaintletter.get("PersonnelName"))
                .set("PersonnelPhone", complaintletter.get("PersonnelPhone"))
                .set("AppealMatter", complaintletter.get("AppealMatter"))
                .set("FactReason", complaintletter.get("FactReason"));
        render("/ComplaintLetterOP.html");
    }

    public void save() {
        if (!IDNumber.availableIDNumber(get("PersonNumber"))) {
            set("InfoText1", "出错啦！")
                    .set("InfoText2", "请核实身份证号码！");
        } else {
            Complaintletter complaintletter = new Complaintletter();
            complaintletter.set("PersonName", get("PersonName"))
                    .set("PersonNumber", get("PersonNumber"))
                    .set("PersonAge", IDNumber.getAge(get("PersonNumber")))
                    .set("PersonSex", IDNumber.get(get("PersonNumber")))
                    .set("PersonPhone", get("PersonPhone"))
                    .set("PersonAddress", get("PersonAddress"))
                    .set("ComplaintDate", new Date())
                    .set("CompanyName", get("CompanyName"))
                    .set("CompanyAddress", get("CompanyAddress"))
                    .set("LegalName", get("LegalName"))
                    .set("LegalPosition", get("LegalPosition"))
                    .set("LegalPhone", get("LegalPhone"))
                    .set("PersonnelName", get("PersonnelName"))
                    .set("PersonnelPhone", get("PersonnelPhone"))
                    .set("AppealMatter", get("AppealMatter"))
                    .set("FactReason", get("FactReason"))
                    .save();
            set("InfoText1", "成功啦！")
                    .set("InfoText2", "请联系工作人员进行审核！");
        }
        render("/Info.html");
    }

    public void delete() {
        complainletterService.deleteById(getInt("id"));
        redirect("/c/i");
    }

    public void next() {
        Complaintletter complaintletter = complainletterService.findById(getInt("id"));
        Filingcase filingcase = new Filingcase();
        filingcase.set("PersonName", complaintletter.get("PersonName"))
                .set("PersonNumber", complaintletter.get("PersonNumber"))
                .set("PersonAge", complaintletter.get("PersonAge"))
                .set("PersonSex", complaintletter.get("PersonSex"))
                .set("PersonPhone", complaintletter.get("PersonPhone"))
                .set("PersonAddress", complaintletter.get("PersonAddress"))
                .set("ComplaintDate", complaintletter.get("ComplaintDate"))
                .set("CompanyName", complaintletter.get("CompanyName"))
                .set("CompanyAddress", complaintletter.get("CompanyAddress"))
                .set("LegalName", complaintletter.get("LegalName"))
                .set("LegalPosition", complaintletter.get("LegalPosition"))
                .set("LegalPhone", complaintletter.get("LegalPhone"))
                .set("PersonnelName", complaintletter.get("PersonnelName"))
                .set("PersonnelPhone", complaintletter.get("PersonnelPhone"))
                .set("AppealMatter", complaintletter.get("AppealMatter"))
                .set("FactReason", complaintletter.get("FactReason"))
                .save();
        Map<String, String> map = new HashMap<>();
        map.put("PersonName", complaintletter.get("PersonName"));
        map.put("PersonNumber", complaintletter.get("PersonNumber"));
        map.put("PersonAge", complaintletter.get("PersonAge"));
        map.put("PersonSex", complaintletter.get("PersonSex"));
        map.put("PersonPhone", complaintletter.get("PersonPhone"));
        map.put("PersonAddress", complaintletter.get("PersonAddress"));
        map.put("ComplaintDate", complaintletter.get("ComplaintDate"));
        map.put("CompanyName", complaintletter.get("CompanyName"));
        map.put("CompanyAddress", complaintletter.get("CompanyAddress"));
        map.put("LegalName", complaintletter.get("LegalName"));
        map.put("LegalPosition", complaintletter.get("LegalPosition"));
        map.put("LegalPhone", complaintletter.get("LegalPhone"));
        map.put("PersonnelName", complaintletter.get("PersonnelName"));
        map.put("PersonnelPhone", complaintletter.get("PersonnelPhone"));
        map.put("AppealMatter", complaintletter.get("AppealMatter"));
        map.put("FactReason", complaintletter.get("FactReason"));

        LocalDate date = LocalDate.now();
        DateTimeFormatter yyyy = DateTimeFormatter.ofPattern("yyyy");
        DateTimeFormatter MM = DateTimeFormatter.ofPattern("MM");
        DateTimeFormatter dd = DateTimeFormatter.ofPattern("dd");
        String path = "D:\\现场受理\\" + date.format(yyyy) + "\\" + date.format(MM) + "\\" + date.format(dd) + "\\";
        CreatWordByModel("D:\\TemplateDoc.docx", map, path + complaintletter.get("PersonNumber") + "-" + complaintletter.get("PersonName") + ".docx");
        String printerName = PropKit.use("config-dev.txt").get("printer");
        printWord(path + complaintletter.get("PersonNumber") + "-" + complaintletter.get("PersonName") + ".docx", printerName);
        set("InfoText1", "投诉已受理")
                .set("InfoText2", "请查看打印信息！");
        render("/Info.html");
    }
}
