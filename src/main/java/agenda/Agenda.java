package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {
    Set<Event> lesEvenements = new HashSet<>();
    public HashSet<Event> mesEvents = new HashSet<Event>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        this.mesEvents.add(e);

    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> today = new ArrayList();
        for (Event e : mesEvents) {
            if (e.isInDay(day)) {
                today.add(e);
            }

        }
        return today;
    }
    
    
    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList lesTitres = new ArrayList();
        for (Event e : lesEvenements) {
            if (e.getTitle().equals(title)) {
                lesTitres.add(e);
            }
        }
        return lesTitres;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        for (Event event : lesEvenements) {
            if ((event.getStart().isEqual(event.getStart())
                    || event.getStart().isAfter(event.getStart()) && event.getStart().isBefore(event.getStart().plus(event.getDuration()))
                    || event.getStart().plus(event.getDuration()).isAfter(event.getStart()) && event.getStart().plus(event.getDuration()).isBefore(event.getStart().plus(event.getDuration())))                 
                        || event.getStart().isEqual(event.getStart())
                        || event.getStart().plus(event.getDuration()).isEqual(event.getStart().plus(event.getDuration())))
            {
                return false;

            }
        }
        return true;
    }
}
