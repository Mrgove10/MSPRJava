package com.recycl.dashboard.back.DAO;

import com.recycl.dashboard.back.Beans.DemandeEnlevement;
import com.recycl.dashboard.back.Beans.Entreprise;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EntrepriseDAO {
    protected Connection connect = null;

    public EntrepriseDAO(Connection conn) {
        this.connect = conn;
    }

    public Entreprise GetById(int id){
        Entreprise entreprise = new Entreprise();
        int idAddress = -1;

        try {
            String query = "SELECT * " +
                    "FROM MSPR_ENTREPRISE " +
                    "WHERE ID = ?";
            PreparedStatement ps = this.connect.prepareStatement(query);
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                entreprise.setId(rs.getInt("ID"));
                entreprise.setSiret(rs.getLong("SIRET"));
                entreprise.setRaisonSociale(rs.getString("RAISON_SOCIAL"));
                entreprise.setTel(rs.getString("TEL"));
                entreprise.setNomContact(rs.getString("NOM_CONTACT"));
                idAddress = rs.getInt("ID_ADRESSE");
            }

            AdresseDAO adresseDAO = new AdresseDAO(connect);
            entreprise.setAdresse(adresseDAO.GetById(idAddress));

            rs.close();

        } catch (SQLException e) {
            return null;
        } finally {
            if (this.connect != null) {
                return entreprise;
            }
        }

        return null;
    }
}
