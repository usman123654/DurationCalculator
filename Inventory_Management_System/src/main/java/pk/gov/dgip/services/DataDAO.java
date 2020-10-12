 package pk.gov.dgip.services;

import java.util.List;
import pk.gov.dgip.entities.Data;

public interface DataDAO
{
    public List<Data> findAll();
}