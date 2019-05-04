package com.raul.paginasamarillas.repositories;

import com.raul.paginasamarillas.models.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyRepository {

    private static List<Company> companys = new ArrayList<>();

    private static List<Company> companys_category;

    static {
        companys.add(new Company(100,"Universidad","Britanico","Jr:Javier Prado #966","966500658","britanico@gmail.com","www.britanico.edu.pe","britanico","Contamos con cursos, clases y exámenes de certificación internacional de inglés. Conoce nuestra oferta cultural y visita nuestra biblioteca."));
        companys.add(new Company(200,"Universidad","Universidad Tecnologica del Peru","Jr:Alameda Sur #543-Barranco","987654321","utec@gmail.com","www.utec.edu.pe","utec","Universidad creada por los hermanos Hoschilds."));
        companys.add(new Company(300,"Institutos","Tecsup","Av: Cascanueces #546-Santa Anita","09876543","tecsup_centro@tecsup.edu.pe","www.tecsup.edu.pe","tecsup","Instituto que forma tecnicos profesionales en tecnologia"));
        companys.add(new Company(400,"Empresas","Volvo","Av: Frutales #459 - Santa Anita","12347890","volvo@gmail.com","www.volvocars.com/pe","volvo","Camiones de ultima generacion y trailers."));
        companys.add(new Company(500,"Empresas","Nissan","Av: Panamericana Norte #345-San Martin de Porres","966500755","www.nissan.pe","www.nissan.com","nissan","Camionetas de ultima generación."));
        companys.add(new Company(600,"Restaurantes","KFC","Av Aviacion #4578-Barranco","966500755","kfc@gmail.com","www.kfc.com.pe","kfc","Pollos crujiente y jugosos con un sabor esquisito"));
        companys.add(new Company(700,"Restaurantes","Norkys","Jr:Javier Prado 897-San Juan de Lurigancho","966500755","norkys.pe","www.norkys.com","norkys","Pollos a la brasa a gusto del cliente."));
        companys.add(new Company(800,"Restaurantes","Pizza Hut","Av: La Molina 9876 - La Molina","966500755","pizzahut@gmail.com","www.pizzahut.com.pe","pizzahut","Pizza horneados con un sabaor unico."));
        companys.add(new Company(900,"Empresa","Ferreyros","Av: Argentina #456 - Callao","966500755","ferreyros@gmail.com","www.ferreyros.com.pe","ferreyros","Maquinarias pesadas"));
        companys.add(new Company(1000,"Institutos","Norkys","Jr:Javier Prado #966","966500755","norkys@gmail.com","www.norkys.com","nissan","Pollos al horno"));
        companys.add(new Company(1100,"Institutos","Norkys","Jr:Javier Prado #966","966500755","norkys@gmail.com","www.norkys.com","nissan","Pollos al horno"));
        companys.add(new Company(1200,"Universidad","Britanico","Jr:Javier Prado #966","966500658","britanico@gmail.com","www.britanico.edu.pe","britanico","Contamos con cursos, clases y exámenes de certificación internacional de inglés. Conoce nuestra oferta cultural y visita nuestra biblioteca."));
        companys.add(new Company(1300,"Universidad","Universidad Tecnologica del Peru","Jr:Alameda Sur #543-Barranco","987654321","utec@gmail.com","www.utec.edu.pe","utec","Universidad creada por los hermanos Hoschilds."));
        companys.add(new Company(1400,"Institutos","Tecsup","Av: Cascanueces #546-Santa Anita","09876543","tecsup_centro@tecsup.edu.pe","www.tecsup.edu.pe","tecsup","Instituto que forma tecnicos profesionales en tecnologia"));
        companys.add(new Company(2400,"Empresas","Volvo","Av: Frutales #459 - Santa Anita","12347890","volvo@gmail.com","www.volvocars.com/pe","volvo","Camiones de ultima generacion y trailers."));
        companys.add(new Company(1500,"Empresas","Nissan","Av: Panamericana Norte #345-San Martin de Porres","966500755","www.nissan.pe","www.nissan.com","nissan","Camionetas de ultima generación."));
        companys.add(new Company(1600,"Restaurantes","KFC","Av Aviacion #4578-Barranco","966500755","kfc@gmail.com","www.kfc.com.pe","kfc","Pollos crujiente y jugosos con un sabor esquisito"));
        companys.add(new Company(1700,"Restaurantes","Norkys","Jr:Javier Prado 897-San Juan de Lurigancho","966500755","norkys.pe","www.norkys.com","norkys","Pollos a la brasa a gusto del cliente."));
        companys.add(new Company(1800,"Restaurantes","Pizza Hut","Av: La Molina 9876 - La Molina","966500755","pizzahut@gmail.com","www.pizzahut.com.pe","pizzahut","Pizza horneados con un sabaor unico."));

    }

    public static List<Company> getCompanys() {
        return companys;
    }

    public static Company getCompanyById(Integer id){
        for(Company company:companys){
            if(company.getId().equals(id)){
                return company;
            }
        }
        return null;
    }

    public static List<Company> filterCompaniesByCategory(String category) {
        companys_category = new ArrayList<>();
        for (Company company : companys) {
            if(company.getCategory().equalsIgnoreCase(category)) {
                companys_category.add(company);
            }
        }
        return companys_category;
    }
}
