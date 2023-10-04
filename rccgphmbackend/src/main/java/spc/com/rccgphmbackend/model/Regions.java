/**
 * Created By SPC On
 * Date:21/09/2023
 * Time:17:00
 * Project Name:spc.com.rccgphmbackend.model
 */

package spc.com.rccgphmbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Data
@AllArgsConstructor
@Document(collection = "Regions")
public class Regions {

    public static Map<String, List<String>> getRegions(){

        Map<String, List<String>> regionMap  = new HashMap<>();

        regionMap.put("Region 1", Arrays.asList("Lagos1", "Lagos11", "Lagos26", "Lagos43", "Lagos45", "Lagos70", "Lagos71", "Lagos73", "Lagos79", "Lagos82", "Lagos93"));
        regionMap.put("Region 2", Arrays.asList( "Lagos8", "Lagos9", "Lagos13", "Lagos14", "Lagos50", "Lagos51", "Lagos56", "Lagos68", "Lagos84", "Lagos85", "Lagos87", "Lagos97"));
        regionMap.put("Region 3", Arrays.asList("Osun1", "Osun2", "Osun3", "Osun4", "Osun5", "Osun6", "Osun7", "Osun8", "Osun9", "Osun10", "Osun11", "Osun12"));
        regionMap.put("Region 4", Arrays.asList("Kwara1", "Kwara2", "Kwara3", "Kwara4", "Kwara5", "Kwara6", "Kwara7", "Kwara8"));
        regionMap.put("Region 5", Arrays.asList("Rivers1", "Rivers2", "Rivers3", "Rivers4", "Rivers5", "Rivers6", "Rivers7", "Rivers8", "Rivers9", "Rivers10", "Rivers11", "Rivers12", "Rivers13", "Rivers14", "Rivers15"));
        regionMap.put("Region 6", Arrays.asList("Enugu1", "Enugu2", "Enugu3", "Enugu4", "Enugu5", "Anambra1", "Anambra2", "Anambra3", "Anambra4", "Ebonyi1", "Ebonyi2"));
        regionMap.put("Region 7", Arrays.asList("Adamawa", "Taraba1", "Taraba2"));
        regionMap.put("Region 8", Arrays.asList("Plateau1", "Plateau2", "Plateau3", "Plateau4", "Plateau5"));
        regionMap.put("Region 9", Arrays.asList("Kano1", "Kano2", "Katsina", "Jigawa"));
        regionMap.put("Region 10", Arrays.asList("FCT1", "FCT2", "FCT3", "FCT4", "FCT5", "FCT6", "FCT7", "FCT8", "FCT9", "FCT10", "FCT11", "FCT12", "FCT13", "FCT14", "FCT15", "FCT16", "FCT17", "FCT18"));
        regionMap.put("Region 11", Arrays.asList("Lagos6", "Lagos16", "Lagos18", "Lagos19", "Lagos20", "Lagos21", "Lagos36", "Lagos53", "Lagos54", "Lagos64", "Lagos65", "Lagos76", "Lagos88", "Lagos100"));
        regionMap.put("Region 12", Arrays.asList("Ogun1", "Ogun2", "Ogun3", "Ogun4", "Ogun5", "Ogun6", "Ogun7", "Ogun8", "Ogun9", "Ogun10", "Ogun11", "Ogun12", "Ogun13", "Ogun18", "Ogun20", "Ogun21", "Ogun22", "Ogun23", "Ogun24", "Ogun25", "Ogun29", "Ogun30", "Ogun31"));
        regionMap.put("Region 13", Arrays.asList("Edo1", "Edo2", "Edo4", "Edo6", "Edo", "Edo9", "Edo11", "Edo13", "Edo15", "Edo16"));
        regionMap.put("Region 14", Arrays.asList("Akwa Ibom1", "Akwa Ibom2", "Akwa Ibom3", "Akwa Ibom4", "Akwa Ibom5", "Akwa Ibom6", "Akwa Ibom7", "Akwa Ibom8", "Akwa Ibom9", "Akwa Ibom10", "Akwa Ibom11", "Akwa Ibom12"));
        regionMap.put("Region 15", Arrays.asList("Abia1", "Abia2", "Abia3", "Abia4", "Abia5", "Abia6", "Imo1", "Imo2", "Imo3", "Imo4"));
        regionMap.put("Region 16", Arrays.asList("Borno", "Borno2", "Yobe"));
        regionMap.put("Region 17", Arrays.asList("Bauchi", "Gombe"));
        regionMap.put("Region 18", Arrays.asList("Sokoto", "Zamfara", "Kebbi"));
        regionMap.put("Region 19", Arrays.asList("Lagos2", "Lagos23", "Lagos27", "Lagos32", "Lagos40", "Lagos44", "Lagos60", "Lagos61", "Lagos77", "Lagos81", "Lagos89", "Lagos92"));
        regionMap.put("Region 20", Arrays.asList("Lagos4", "Lagos5", "Lagos15", "Lagos24", "Lagos34", "Lagos35", "Lagos39", "Lagos46", "Lagos47", "Lagos48", "Lagos66", "Lagos67"));
        regionMap.put("Region 21", Arrays.asList("Oyo1", "Oyo2", "Oyo5", "Oyo10", "Oyo11", "Oyo12", "Oyo13", "Oyo14", "Oyo15", "Oyo16", "Oyo17", "Oyo19", "Oyo21"));
        regionMap.put("Region 22", Arrays.asList("Ondo1", "Ondo3", "Ondo4", "Ondo7", "Ondo8", "Ondo9", "Ondo11", "Ondo13", "Ondo16"));
        regionMap.put("Region 23", Arrays.asList("Delta1", "Delta2", "Delta3", "Delta4", "Delta5", "Delta6", "Delta8", "Delta10", "Delta11", "Delta12", "Delta13", "Delta16", "Delta18", "Delta19", "Delta20", "Delta21"));
        regionMap.put("Region 24", Arrays.asList("Kogi1", "Kogi2", "Kogi3", "Kogi4", "Kogi5", "Kogi6", "Kogi7"));
        regionMap.put("Region 25", Arrays.asList("Ekiti1", "Ekiti2", "Ekiti3", "Ekiti4", "Ekiti5", "Ekiti6", "Ekiti7", "Ekiti8", "Ekiti9", "Ekiti10", "Ekiti11"));
        regionMap.put("Region 26", Arrays.asList("Lagos22", "Lagos33", "Lagos41", "Lagos55", "Lagos58", "Lagos62", "Lagos63", "Lagos75", "Lagos97", "Lagos98", "Lagos99"));
        regionMap.put("Region 27", Arrays.asList("Bayelsa1", "Bayelsa2", "Bayelsa3", "Bayelsa4", "Bayelsa5"));
        regionMap.put("Region 28", Arrays.asList("Nasarawa1", "Nasarawa2", "Nasarawa3", "Nasarawa4"));
        regionMap.put("Region 29", Arrays.asList("Cross River1", "Cross River2", "Cross River3", "Cross River4", "Cross River5", "Cross River6"));
        regionMap.put("Region 30", Arrays.asList("Kaduna1", "Kaduna2", "Kaduna3", "Kaduna4", "Kaduna5", "Kaduna6"));
        regionMap.put("Region 31", Arrays.asList("Lagos7", "Lagos25", "Lagos29", "Lagos37", "Lagos52", "Lagos59", "Lagos68", "Lagos74", "Lagos78", "Lagos80", "Lagos101", "Lagos102"));
        regionMap.put("Region 32", Arrays.asList("Ogun1", "Ogun6", "Ogun7", "Ogun12", "Ogun14", "Ogun15", "Ogun16", "Ogun17", "Ogun19", "Ogun21", "Ogun26", "Ogun27", "Ogun28"));
        regionMap.put("Region 33", Arrays.asList("Rivers2", "Rivers3", "Rivers5", "Rivers7", "Rivers8", "Rivers11", "Rivers12", "Rivers16", "Rivers17"));
        regionMap.put("Region 34", Arrays.asList("Delta3", "Delta7", "Delta9", "Delta14", "Delta15", "Delta17"));
        regionMap.put("Region 35", Arrays.asList("Youth1", "Youth2", "Youth3", "Youth4", "Youth5", "Youth6", "Youth7", "Youth8", "Youth9", "Youth10", "Youth11", "Youth12", "Youth13", "Youth14"));
        regionMap.put("Region 36", Arrays.asList("Lagos12", "Lagos18", "Lagos30", "Lagos31", "Lagos33", "Lagos72", "Lagos90", "Lagos91", "Lagos94"));
        regionMap.put("Region 37", Arrays.asList("Lagos10", "Lagos17", "Lagos28", "Lagos42", "Lagos49", "Lagos57", "Lagos83", "Lagos86", "Lagos96"));
        regionMap.put("Region 38", Arrays.asList("Edo3", "Edo5", "Edo7", "Edo8", "Edo10", "Edo12", "Edo14"));
        regionMap.put("Region 39", Arrays.asList("Ondo2", "Ondo5", "Ondo6", "Ondo10", "Ondo12", "Ondo14", "Ondo15"));
        regionMap.put("Region 40", Arrays.asList("Benue1", "Benue2", "Benue3", "Benue4", "Benue5"));
        regionMap.put("Region 41", Arrays.asList("Niger1", "Niger2", "Niger3", "Niger4"));
        regionMap.put("Region 42", Arrays.asList("Oyo3", "Oyo4", "Oyo6", "Oyo7", "Oyo8", "Oyo9", "Oyo18", "Oyo20", "Oyo22"));

        return regionMap;
    }
}
