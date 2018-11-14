package io.pivotal.pal.tracker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements TimeEntryRepository {

    HashMap<Long, TimeEntry> hashMapTimeEntries = new HashMap<Long, TimeEntry>();

    //List<TimeEntry> timeEntryList = new ArrayList<TimeEntry>();

    public TimeEntry create(TimeEntry newTime) {
        newTime.setId(hashMapTimeEntries.size() + 1);
        hashMapTimeEntries.put(newTime.getId(), newTime);
        return newTime;
    }

    public List<TimeEntry> list() {
        List<TimeEntry> listEntries = new ArrayList<TimeEntry>(hashMapTimeEntries.values());
        return listEntries;
    }

    public TimeEntry update(long oldTimeEntryId, TimeEntry newTimeEntry) {
        TimeEntry updatedEntry = hashMapTimeEntries.get(oldTimeEntryId);
        updatedEntry.setProjectId(newTimeEntry.getProjectId());
        updatedEntry.setUserId(newTimeEntry.getUserId());
        updatedEntry.setDate(newTimeEntry.getDate());
        updatedEntry.setHours(newTimeEntry.getHours());

        return updatedEntry;
    }

    public void delete(long timeEntryToDelete) {
        hashMapTimeEntries.remove(timeEntryToDelete);
    }

    public TimeEntry find(long timeEntryId) {

        return hashMapTimeEntries.get(timeEntryId)!=null ? hashMapTimeEntries.get(timeEntryId) : null;

    }
}
