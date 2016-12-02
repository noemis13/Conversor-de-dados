CREATE UNIQUE INDEX coordenadas ON wkt ( id_wkt);

CREATE INDEX coordenadas2 ON wkt using  SPGiST(known_text );

CREATE UNIQUE INDEX id_estadoo ON statefp(id_state, id_statefp);

CREATE UNIQUE INDEX FipCodigo ON countyfp(code_fip, id_countyfp);

CREATE UNIQUE INDEX nCasa_endereco_borda_esquerda ON lfromadd(number_house_adress_left_border, id_lfromadd);

CREATE UNIQUE INDEX nCasa_endereco_borda_esquerda ON ltoadd (number_house_left_border, id_ltoadd);

CREATE UNIQUE INDEX nCasa_endereco_borda_direita ON rfromadd(number_house_adress_right_border, id_rfromadd);

CREATE UNIQUE INDEX nCasa_borda_direita ON rtoadd(number_house_right_border, id_rtoadd);

CREATE UNIQUE INDEX codigoZip_bordaEsquerda ON zipl(zip_code_left, id_zipl);

CREATE UNIQUE INDEX codigoZip_bordaDireita ON zipr(zip_code_right, id_zipr);

CREATE UNIQUE INDEX idFacePermanente_bordaEsquerda ON tfidl(left_face_id, id_lfromadd, id_ltoadd, id_zipl, id_tfidl);

CREATE UNIQUE INDEX idFacePermanente_bordaDireita ON tfidr(right_face_id, id_rfromadd, id_rtoadd, id_zipr, id_tfidr);

CREATE UNIQUE INDEX noPermanenteBorda_comeco ON tnidf(first_node, id_tnidf);

CREATE UNIQUE INDEX noPermanenteBorda_Final ON tnidt(border_node, id_tnidt);

CREATE UNIQUE INDEX id_BordaPermanente ON tlid(border_id, id_tnidf, id_tnidt, id_tfidl, id_tfidr, id_tlid);

CREATE UNIQUE INDEX codigo_face_principal ON mtfcc(code_face, id_mtfcc);

CREATE UNIQUE INDEX metadados_especiais ON smid(especial_metadados, id_smid);

CREATE UNIQUE INDEX indicador_recursos_hidraulicos ON hydroflg(hydraulic_resources, id_hydroflg);

CREATE UNIQUE INDEX indicador_recursos_ferroviario ON railflg(rail_resources, id_railflg);

CREATE UNIQUE INDEX indicador_recursos_estrada ON roadflg(road_resources, id_roadflg);

CREATE UNIQUE INDEX indicador_estrada_pavimentada ON deckedroad(decked_road_id, id_deckedroad);

CREATE UNIQUE INDEX tipos_de_pacotes ON ttyp(pack_type, id_ttyp);

CREATE UNIQUE INDEX indicador_pacotes_artificiais ON artpath(artificial_pack_id, id_ttyp, id_artpath);

CREATE UNIQUE INDEX caracteristicas_gerais ON featcat(general_characteristics, id_hydroflg, id_railflg, id_roadflg, id_deckedroad, id_artpath, id_featcat);

CREATE UNIQUE INDEX flag_estradas_divididas ON divroad(div_road_flag, id_divroad);

CREATE UNIQUE INDEX flag_passagem_especial ON passflg(especial_pass_flag, id_passflg);

CREATE UNIQUE INDEX flag_persistencia_geografica ON persist(geograph_persist_flag, id_persist);

CREATE UNIQUE INDEX indicador_deslocamento_face_lado_esquerdo_aresta ON offsetl(left_flag, id_offsetl);

CREATE UNIQUE INDEX indicador_caracteristicas_linear ON olfflg(linear_id, id_divroad, id_passflg, id_persist, id_olfflg);

CREATE UNIQUE INDEX tipos_extensoes ON exttyp(extension_type, id_exttyp);

CREATE UNIQUE INDEX indicador_deslocamento_face_lado_direito_aresta ON offsetr(right_side, id_offsetr);

CREATE UNIQUE INDEX flag_corredores_geograficos ON gcseflg(geograph_flag, id_gcseflg);

CREATE UNIQUE INDEX caracteristicas_arestas ON fullname(name_edges, id_fullname, id_wkt, id_statefp, id_countyfp, id_tlid, id_tfidl, id_tfidr, id_mtfcc, id_smid, id_lfromadd, id_ltoadd, id_rfromadd, id_rtoadd, id_zipl, id_zipr, id_hydroflg, id_railflg, id_roadflg, id_passflg, id_divroad, id_exttyp, id_deckedroad, id_artpath, id_persist, id_gcseflg, id_offsetl, id_offsetr, id_tnidf, id_tnidt);



