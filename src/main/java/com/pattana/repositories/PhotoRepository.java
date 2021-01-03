package com.pattana.repositories;

import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.pattana.model.Photo;



public interface PhotoRepository extends MongoRepository<Photo, String> {


    //------------------------------------------- equality
    
    public Photo findByName(String photoName);
    
    @Query("{name : ?0}")
    public Photo findByNameQuery(String photoName);
    


    //------------------------------------------- not equal
    
    public List<Photo> findByNameNot(String photoName);

    @Query("{name : {$ne : ?0}}")
    public List<Photo> findByNameNotQuery(String photoName);

    //------------------------------------------- like / regex

    public List<Photo> findByNameLike(String photoName);

    public List<Photo> readByNameRegex(String photoName);
    
    @Query("{name : {$regex : ?0}}")
    public List<Photo> getByNameRegexQuery(String photoName);
    
    
    @Query("{seqSec : {$regex : ?0}}")
    public List<Photo> getBySeqSecRegexQuery(int seqSec);
    
    //------------------------------------------- nested
    
  
    
    @Query("{'continent.name' : ?0}")
    public List<Photo> findByContinentNameQuery(String continentName);
    
    //------------------------------------------- null / not null
    

    
    @Query("{'population' : null}")
    public List<Photo> findByPopulationIsNullQuery();



    @Query("{'population' : {$ne : null}}")
    public List<Photo> findByPopulationIsNotNullQuery();
    
    //------------------------------------------- less than / greater than



    @Query("{'area' : {$lt : ?0}}")
    public List<Photo> findByAreaInSquareMilesLessThanQuery(int area);



    @Query("{'population' : {$gt : ?0}}")
    public List<Photo> findByPopulationGreaterThanQuery(int population);
    
    //------------------------------------------- between
    

    
    @Query("{'population' : {$gt : ?0, $lt : ?1}}")
    public List<Photo> findByPopulationBetweenQuery(int start, int end);
    
    //------------------------------------------- and



    @Query("{'continent.name' : ?0, population : {$lt : ?1}}")
    public List<Photo> findByContinentNameAndPopulationLessThanQuery(String continentName, int pop);
    
    //------------------------------------------- or
    

    
    @Query("{'$or' : [{'population' : {$lt : ?0}}, {'area' : {$lt : ?1}}]}")
    public List<Photo> findByPopulationLessThanOrAreaInSquareMilesLessThanQuery(int pop, int area);

    //------------------------------------------- order by
    


    //------------------------------------------- fields
    
    @Query(value="{'continent.name' : ?0}", fields="{_id : 0, name : 1}")
    public List<Photo> findByContinentNameJustReturnNameQuery(String continentName);
}
