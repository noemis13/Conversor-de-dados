package datasetparabanco;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.compress.compressors.CompressorException;
import org.apache.commons.compress.compressors.CompressorInputStream;
import org.apache.commons.compress.compressors.CompressorStreamFactory;

/**
 *
 * @author ns
 */
public class Edges {

    public static void lerArquivoCSV() throws CompressorException, SQLException, ClassNotFoundException {

        try {
            FileInputStream fin = new FileInputStream("/home/ns/Documentos/Estudos UTFPR/Trabalhos/Banco de Dados 2/Trabalho2/EDGES.csv.bz2");
            BufferedInputStream bis = new BufferedInputStream(fin);
            CompressorInputStream input = new CompressorStreamFactory().createCompressorInputStream(bis);
            BufferedReader br = new BufferedReader(new InputStreamReader(input));
            String linha = "";
            int i = 3;
            while ((linha = br.readLine()) != null) {
                //System.out.println(linha);
                divideDadosArquivo(linha);

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Edges.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Edges.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("Fim do arquivo!");
        System.out.println("Inserção terminada! :D");

    }

    public static void divideDadosArquivo(String linha) throws SQLException, ClassNotFoundException {
        String[] splitElementos = linha.split("	");

        //wkt
        String known_text = null;
        if (splitElementos[0].isEmpty()) {
            known_text = "vazio";
        } else {
            String[] removeAspas;
            known_text = splitElementos[0];
            removeAspas = known_text.split("\\\"");
            known_text = removeAspas[1];
        }

        //statefp
        int id_state;
        if (splitElementos[1].isEmpty()) {
            id_state = 0;
        } else {
            id_state = Integer.parseInt(splitElementos[1]);
        }

        //counttfp
        int code_fip;
        if (splitElementos[1].isEmpty()) {
            code_fip = 0;
        } else {
            code_fip = Integer.parseInt(splitElementos[2]);
        }

        //tlid
        int border_id;
        if (splitElementos[3].isEmpty()) {
            border_id = 0;
        } else {
            border_id = Integer.parseInt(splitElementos[3]);
        }

        //tfidl
        int left_face_id;
        if (splitElementos[4].isEmpty()) {
            left_face_id = 0;
        } else {
            left_face_id = Integer.parseInt(splitElementos[4]);
        }

        //tfidr
        int right_face_id;
        if (splitElementos[5].isEmpty()) {
            right_face_id = 0;
        } else {
            right_face_id = Integer.parseInt(splitElementos[5]);

        }

        //mtfcc
        String code_face;
        if (splitElementos[6].isEmpty()) {
            code_face = "vazio";
        } else {
            code_face = splitElementos[6];
        }

        //fullname
        String name_edges;
        if (splitElementos[7].isEmpty()) {
            name_edges = "vazio";
        } else {
            name_edges = splitElementos[7];
        }

        //smid
        int especial_metadados;
        if (splitElementos[8].isEmpty()) {
            especial_metadados = 0;
        } else {
            especial_metadados = Integer.parseInt(splitElementos[8]);
        }

        //lfromadd
        String number_house_adress_left_border;
        if (splitElementos[9].isEmpty()) {
            number_house_adress_left_border = "vazio";
        } else {
            number_house_adress_left_border = splitElementos[9];
        }

        //ltoadd
        String number_house_left_border;
        if (splitElementos[10].isEmpty()) {
            number_house_left_border = "vazio";
        } else {
            number_house_left_border = splitElementos[10];
        }

        //rfromadd
        String number_house_adress_right_border;
        if (splitElementos[11].isEmpty()) {
            number_house_adress_right_border = "vazio";
        } else {
            number_house_adress_right_border = splitElementos[11];
        }

        //rtoadd
        String number_house_right_border;
        if (splitElementos[12].isEmpty()) {
            number_house_right_border = "vazio";
        } else {
            number_house_right_border = splitElementos[12];
        }

        //zipl
        int zip_code_left;
        if (splitElementos[13].isEmpty()) {
            zip_code_left = 0;
        } else {
            zip_code_left = Integer.parseInt(splitElementos[13]);

        }

        //zipr
        int zip_code_right;
        if (splitElementos[14].isEmpty()) {
            zip_code_right = 0;
        } else {
            zip_code_right = Integer.parseInt(splitElementos[14]);
        }

        //featcat
        String general_characteristics;
        if (splitElementos[15].isEmpty()) {
            general_characteristics = "vazio";
        } else {
            general_characteristics = splitElementos[15];
        }

        //hydroflg
        String hydraulic_resources;
        if (splitElementos[16].isEmpty()) {
            hydraulic_resources = "vazio";
        } else {
            hydraulic_resources = splitElementos[16];
        }

        //railflg
        String rail_resources;
        if (splitElementos[17].isEmpty()) {
            rail_resources = "vazio";
        } else {
            rail_resources = splitElementos[17];
        }

        //roadflg
        String road_resources;
        if (splitElementos[18].isEmpty()) {
            road_resources = "vazio";
        } else {
            road_resources = splitElementos[18];
        }

        //olfflg
        String linear_id;
        if (splitElementos[19].isEmpty()) {
            linear_id = "vazio";
        } else {
            linear_id = splitElementos[19];
        }

        //passflg
        String especial_pass_flag;
        if (splitElementos[20].isEmpty()) {
            especial_pass_flag = "vazio";
        } else {
            especial_pass_flag = splitElementos[20];
        }

        //divroad
        String div_road_flag;
        if (splitElementos[21].isEmpty()) {
            div_road_flag = "vazio";
        } else {
            div_road_flag = splitElementos[21];
        }

        //exttyp
        String extension_type;
        if (splitElementos[22].isEmpty()) {
            extension_type = "vazio";
        } else {
            extension_type = splitElementos[22];
        }

        //ttyp
        String pack_type;
        if (splitElementos[23].isEmpty()) {
            pack_type = "vazio";
        } else {
            pack_type = splitElementos[23];
        }

        //deckedroad
        String decked_road_id;
        if (splitElementos[24].isEmpty()) {
            decked_road_id = "vazio";
        } else {
            decked_road_id = splitElementos[24];
        }

        //artpath
        String artificial_pack_id;
        if (splitElementos[25].isEmpty()) {
            artificial_pack_id = "vazio";
        } else {
            artificial_pack_id = splitElementos[25];
        }

        //persist
        String geograph_persist_flag;
        if (splitElementos[26].isEmpty()) {
            geograph_persist_flag = "vazio";
        } else {
            geograph_persist_flag = splitElementos[26];
        }

        //gcseflg
        String geograph_flag = splitElementos[27];
        if (splitElementos[27].isEmpty()) {
            geograph_flag = "vazio";
        } else {
            geograph_flag = splitElementos[27];
        }

        //offsetl
        String left_flag;
        if (splitElementos[28].isEmpty()) {
            left_flag = "vazio";
        } else {
            left_flag = splitElementos[29];
        }

        //offsetr
        String right_side;
        if (splitElementos[29].isEmpty()) {
            right_side = "vazio";
        } else {
            right_side = splitElementos[29];
        }
        //tnidf
        int first_node;
        if (splitElementos[30].isEmpty()) {
            first_node = 0;
        } else {
            first_node = Integer.parseInt(splitElementos[30]);
        }
        //tnidt
        int border_node;
        if (splitElementos[31].isEmpty()) {
            border_node = 0;
        } else {
            border_node = Integer.parseInt(splitElementos[31]);
        }

        int cont_id = 1;
        conexao(known_text, id_state, code_fip, border_id, left_face_id, right_face_id, code_face, name_edges, especial_metadados, number_house_adress_left_border,
                number_house_left_border, number_house_adress_right_border, number_house_right_border, zip_code_left, zip_code_right, general_characteristics, hydraulic_resources,
                rail_resources, road_resources, linear_id, especial_pass_flag, div_road_flag, extension_type, pack_type, decked_road_id, artificial_pack_id, geograph_persist_flag,
                geograph_flag, left_flag, right_side, first_node, border_node, cont_id);
        
        
    }

    public static void conexao(String known_text, int id_state, int code_fip, int border_id, int left_face_id, int right_face_id, String code_face, String name_edges, int especial_metadados, String number_house_adress_left_border, String number_house_left_border, String number_house_adress_right_border, String number_house_right_border, int zip_code_left, int zip_code_right, String general_characteristics, String hydraulic_resources, String rail_resources, String road_resources, String linear_id, String especial_pass_flag, String div_road_flag,
            String extension_type, String pack_type, String decked_road_id, String artificial_pack_id, String geograph_persist_flag, String geograph_flag, String left_flag,
            String right_side, int first_node, int border_node, int cont_id) throws SQLException, ClassNotFoundException {

        String driver = "org.postgresql.Driver";
        String user = "postgres";
        String senha = "root";
        String url = "jdbc:postgresql://localhost:5432/edges";

        Statement stm;

        try {
            Class.forName(driver);
            Connection con = null;
            con = DriverManager.getConnection(url, user, senha);
            stm = con.createStatement();

            String sql = "INSERT into wkt(known_text) VALUES( '" + known_text + "')";
            stm.execute(sql);

            Statement stm1 = con.createStatement();
            String sql1 = "INSERT into statefp(id_state) VALUES('" + id_state + "')";
            stm1.execute(sql1);

            Statement stm2 = con.createStatement();
            String sql2 = "INSERT into countyfp(code_fip) VALUES('" + code_fip + "')";
            stm2.execute(sql2);

            Statement stm3 = con.createStatement();
            String sql3 = "INSERT into lfromadd(number_house_adress_left_border) VALUES('" + number_house_adress_left_border + "')";
            stm3.execute(sql3);

            Statement stm4 = con.createStatement();
            String sql4 = "INSERT into ltoadd(number_house_left_border) VALUES('" + number_house_left_border + "')";
            stm4.execute(sql4);

            Statement stm5 = con.createStatement();
            String sql5 = "INSERT into rfromadd(number_house_adress_right_border) VALUES('" + number_house_adress_right_border + "')";
            stm5.execute(sql5);

            Statement stm6 = con.createStatement();
            String sql6 = "INSERT into rtoadd(number_house_right_border) VALUES('" + number_house_right_border + "')";
            stm6.execute(sql6);

            Statement stm7 = con.createStatement();
            String sql7 = "INSERT into zipl(zip_code_left) VALUES('" + zip_code_left + "')";
            stm7.execute(sql7);

            Statement stm8 = con.createStatement();
            String sql8 = "INSERT into zipr(zip_code_right) VALUES('" + zip_code_right + "')";
            stm8.execute(sql8);

            Statement stm9 = con.createStatement();
            String sql9 = "INSERT into tfidl(left_face_id, id_lfromadd, id_ltoadd, id_zipl) VALUES('" + left_face_id + "', '" + cont_id + "', '" + cont_id + "', '" + cont_id + "' )";
            stm9.execute(sql9);

            Statement stm10 = con.createStatement();
            String sql10 = "INSERT into tfidr(right_face_id, id_rfromadd, id_rtoadd, id_zipr) VALUES('" + left_face_id + "', '" + cont_id + "', '" + cont_id + "', '" + cont_id + "')";
            stm10.execute(sql10);

            Statement stm11 = con.createStatement();
            String sql11 = "INSERT into tnidf(first_node) VALUES('" + first_node + "')";
            stm11.execute(sql11);

            Statement stm12 = con.createStatement();
            String sql12 = "INSERT into tnidt(border_node) VALUES('"+border_node+"')";
            stm12.execute(sql12);

            Statement stm13 = con.createStatement();
            String sql13 = "INSERT into tlid(border_id, id_tnidf, id_tnidt, id_tfidl, id_tfidr) VALUES('"+border_id+"', '" + cont_id + "', '" + cont_id + "', '" + cont_id + "', '" + cont_id + "')";
            stm13.execute(sql13);

            Statement stm14 = con.createStatement();
            String sql14 = "INSERT into mtfcc(code_face) VALUES('"+code_face+"')";
            stm14.execute(sql14);
            
            Statement stm16 = con.createStatement();
            String sql16 = "INSERT into smid(especial_metadados) VALUES('"+especial_metadados+"')";
            stm16.execute(sql16);
            
            Statement stm17 = con.createStatement();
            String sql17 = "INSERT into hydroflg(hydraulic_resources) VALUES('"+hydraulic_resources+"')";
            stm17.execute(sql17);

            Statement stm18 = con.createStatement();
            String sql18 = "INSERT into railflg(rail_resources) VALUES('"+rail_resources+"')";
            stm18.execute(sql18);

            Statement stm19 = con.createStatement();
            String sql19 = "INSERT into roadflg(road_resources) VALUES('"+road_resources+"')";
            stm19.execute(sql19);

            
            Statement stm20 = con.createStatement();
            String sql20 = "INSERT into deckedroad(decked_road_id) VALUES('"+decked_road_id+"')";
            stm20.execute(sql20);

            
            Statement stm21 = con.createStatement();
            String sql21 = "INSERT into ttyp(pack_type) VALUES('"+pack_type+"')";
            stm21.execute(sql21);

            
            Statement stm22 = con.createStatement();
            String sql22 = "INSERT into artpath(artificial_pack_id, id_ttyp) VALUES('"+artificial_pack_id+"', '"+cont_id+"')";
            stm22.execute(sql22);

            
            Statement stm23 = con.createStatement();
            String sql23 = "INSERT into featcat(general_characteristics, id_hydroflg, id_railflg, id_roadflg, id_deckedroad, id_artpath) VALUES('"+general_characteristics+"', '"+cont_id+"', '"+cont_id+"', '"+cont_id+"', '"+cont_id+"', '"+cont_id+"')";
            stm23.execute(sql23);

            
            Statement stm24 = con.createStatement();
            String sql24 = "INSERT into divroad(div_road_flag) VALUES('"+div_road_flag+"')";
            stm24.execute(sql24);

            
            Statement stm25 = con.createStatement();
            String sql25 = "INSERT into passflg(especial_pass_flag) VALUES('"+especial_pass_flag+"')";
            stm25.execute(sql25);

            
            Statement stm26 = con.createStatement();
            String sql26 = "INSERT into persist(geograph_persist_flag) VALUES('"+geograph_persist_flag+"')";
            stm26.execute(sql26);

            
            Statement stm27 = con.createStatement();
            String sql27 = "INSERT into offsetl(left_flag) VALUES('"+left_flag+"')";
            stm27.execute(sql27);

            
            Statement stm28 = con.createStatement();
            String sql28 = "INSERT into olfflg(linear_id, id_divroad, id_passflg, id_persist) VALUES("
                    + "'"+div_road_flag+"', '"+cont_id+"', '"+cont_id+"', '"+cont_id+"')";
            stm28.execute(sql28);

            
            Statement stm29 = con.createStatement();
            String sql29 = "INSERT into exttyp(extension_type) VALUES('"+extension_type+"')";
            stm29.execute(sql29);

            
            Statement stm30 = con.createStatement();
            String sql30 = "INSERT into offsetr(right_side) VALUES('"+right_side+"')";
            stm30.execute(sql30);

            
            Statement stm31 = con.createStatement();
            String sql31 = "INSERT into gcseflg(geograph_flag) VALUES('"+geograph_flag+"')";
            stm31.execute(sql31);

            String sql15 = "INSERT into fullname(name_edges, id_wkt, id_statefp, id_countyfp, id_tlid, id_tfidl, "
                    + "id_tfidr, id_mtfcc, id_smid, id_lfromadd, id_ltoadd, id_rfromadd, id_rtoadd, id_zipl, id_zipr,"
                    + "id_hydroflg, id_railflg, id_roadflg, id_passflg, id_divroad, id_exttyp, id_deckedroad, id_artpath,"
                    + "id_persist, id_gcseflg, id_offsetl, id_offsetr, id_tnidf, id_tnidt) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement stm15 = con.prepareStatement(sql15);
            stm15.setString(1, name_edges);
            stm15.setInt(2, cont_id);
            stm15.setInt(3, cont_id);
            stm15.setInt(4, cont_id);
            stm15.setInt(5, cont_id);
            stm15.setInt(6, cont_id);
            stm15.setInt(7, cont_id);
            stm15.setInt(8, cont_id);
            stm15.setInt(9, cont_id);
            stm15.setInt(10, cont_id);
            stm15.setInt(11, cont_id);
            stm15.setInt(12, cont_id);
            stm15.setInt(13, cont_id);
            stm15.setInt(14, cont_id);
            stm15.setInt(15, cont_id);
            stm15.setInt(16, cont_id);
            stm15.setInt(17, cont_id);
            stm15.setInt(18, cont_id);
            stm15.setInt(19, cont_id);
            stm15.setInt(20, cont_id);
            stm15.setInt(21, cont_id);
            stm15.setInt(22, cont_id);
            stm15.setInt(23, cont_id);
            stm15.setInt(24, cont_id);
            stm15.setInt(25, cont_id);
            stm15.setInt(26, cont_id);
            stm15.setInt(27, cont_id);
            stm15.setInt(28, cont_id);
            stm15.setInt(29, cont_id);
            stm15.execute();
             
            cont_id++;
            con.close();
        } catch (ClassNotFoundException ex) {
            System.err.print(ex.getMessage());
        }

    }

    public static void main(String[] args) throws CompressorException, SQLException, ClassNotFoundException {
        lerArquivoCSV();
    }
}
