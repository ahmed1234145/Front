package tn.esprit.ourbank.Service.Interface;

import tn.esprit.ourbank.DAO.Entities.Theme;

import java.util.List;

import java.util.List;

public interface ThemeService {
    List<Theme> retrieveAllTheme();
    Theme addTheme(Theme t);
    void deleteTheme(int id);
    Theme updateTheme(Theme t);
    Theme retrieveTheme(int id);
    int getPostsTotalFeedback(int id);
}
