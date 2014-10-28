package me.philio.disqus.api.resource;

import java.util.List;
import java.util.Map;

import me.philio.disqus.api.exception.ApiException;
import me.philio.disqus.api.model.Response;
import me.philio.disqus.api.model.blacklist.BlacklistEntry;
import retrofit.http.GET;
import retrofit.http.POST;
import retrofit.http.Query;
import retrofit.http.QueryMap;

/**
 * Blacklists resource
 */
public interface Blacklists {

    /**
     * Adds a domain entry/entries to the blacklist
     *
     * @param forum
     * @param domains
     * @param retroactive
     * @param notes
     * @return
     */
    @POST("/blacklists/add.json")
    public Response<List<BlacklistEntry>> addDomains(@Query("forum") String forum,
                                                     @Query("domain") String[] domains,
                                                     @Query("retroactive") int retroactive,
                                                     @Query("notes") String notes)
            throws ApiException;

    /**
     * Adds a word entry/entries to the blacklist
     *
     * @param forum
     * @param words
     * @param retroactive
     * @param notes
     * @return
     */
    @POST("/blacklists/add.json")
    public Response<List<BlacklistEntry>> addWords(@Query("forum") String forum,
                                                   @Query("word") String[] words,
                                                   @Query("retroactive") int retroactive,
                                                   @Query("notes") String notes)
            throws ApiException;

    /**
     * Adds an IP entry/entries to the blacklist
     *
     * @param forum
     * @param ips
     * @param retroactive
     * @param notes
     * @return
     */
    @POST("/blacklists/add.json")
    public Response<List<BlacklistEntry>> addIps(@Query("forum") String forum,
                                                 @Query("ip") String[] ips,
                                                 @Query("retroactive") int retroactive,
                                                 @Query("notes") String notes) throws ApiException;

    /**
     * Adds a user entry/entries to the blacklist
     *
     * @param forum
     * @param users
     * @param retroactive
     * @param notes
     * @return
     */
    @POST("/blacklists/add.json")
    public Response<List<BlacklistEntry>> addUsers(@Query("forum") String forum,
                                                   @Query("user") Long[] users,
                                                   @Query("retroactive") int retroactive,
                                                   @Query("notes") String notes)
            throws ApiException;

    /**
     * Adds an email entry/entries to the blacklist
     *
     * @param forum
     * @param emails
     * @param retroactive
     * @param notes
     * @return
     */
    @POST("/blacklists/add.json")
    public Response<List<BlacklistEntry>> addEmails(@Query("forum") String forum,
                                                    @Query("email") String[] emails,
                                                    @Query("retroactive") int retroactive,
                                                    @Query("notes") String notes)
            throws ApiException;

    /**
     * Returns a list of all blacklist entries
     *
     * @param forum
     * @return
     * @throws ApiException
     */
    @GET("/blacklists/list.json")
    public Response<List<BlacklistEntry>> list(@Query("forum") String forum) throws ApiException;

    /**
     * Returns a list of all blacklist entries
     *
     * @param forum
     * @param optionalParams
     * @return
     * @throws ApiException
     */
    @GET("/blacklists/list.json")
    public Response<List<BlacklistEntry>> list(@Query("forum") String forum,
                                               @QueryMap Map<String, String> optionalParams)
            throws ApiException;

    /**
     * Removes a domain entry/entries to the blacklist
     *
     * @param forum
     * @param domains
     * @return
     */
    @POST("/blacklists/remove.json")
    public Response<List<BlacklistEntry>> removeDomains(@Query("forum") String forum,
                                                        @Query("domain") String[] domains)
            throws ApiException;

    /**
     * Removes a word entry/entries to the blacklist
     *
     * @param forum
     * @param words
     * @return
     */
    @POST("/blacklists/remove.json")
    public Response<List<BlacklistEntry>> removeWords(@Query("forum") String forum,
                                                      @Query("word") String[] words)
            throws ApiException;

    /**
     * Removes an IP entry/entries to the blacklist
     *
     * @param forum
     * @param ips
     * @return
     */
    @POST("/blacklists/remove.json")
    public Response<List<BlacklistEntry>> removeIps(@Query("forum") String forum,
                                                    @Query("ip") String[] ips) throws ApiException;

    /**
     * Removes a user entry/entries to the blacklist
     *
     * @param forum
     * @param users
     * @return
     */
    @POST("/blacklists/remove.json")
    public Response<List<BlacklistEntry>> removeUsers(@Query("forum") String forum,
                                                    @Query("user") Long[] users)
            throws ApiException;

    /**
     * Removes an email entry/entries to the blacklist
     *
     * @param forum
     * @param emails
     * @return
     */
    @POST("/blacklists/remove.json")
    public Response<List<BlacklistEntry>> removeEmails(@Query("forum") String forum,
                                                        @Query("email") String[] emails)
            throws ApiException;


}