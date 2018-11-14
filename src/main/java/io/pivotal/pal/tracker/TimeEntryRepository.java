package io.pivotal.pal.tracker;

import java.util.HashMap;
import java.util.List;

public interface TimeEntryRepository {

    public TimeEntry create(TimeEntry time);
    public TimeEntry find(long timeEntryId);
    public List<TimeEntry> list();
    public TimeEntry update(long oldTimeEntryId, TimeEntry newTimeEntry);
    public void delete(long timeEntryToDelete);
}
