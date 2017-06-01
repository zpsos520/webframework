package com.shua1.common.util;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class JsonUtil
{
  private static Logger logger = LoggerFactory.getLogger("rechargeInfo");
  private static Gson gson = null;
  
  static
  {
    if (gson == null) {
      gson = new Gson();
    }
  }
  
  public static String objectToJson(Object ts)
  {
    logger.info(ts.toString());
    String jsonStr = null;
    if (gson != null) {
      jsonStr = gson.toJson(ts);
    }
    return jsonStr;
  }
  
//  public static String objectToJsonDateSerializer(Object ts, String dateformat)
//  {
//    String jsonStr = null;
//    gson = new GsonBuilder().registerTypeHierarchyAdapter(Date.class, new JsonSerializer()
//    {
//      public JsonElement serialize(Date src, Type typeOfSrc, JsonSerializationContext context)
//      {
//        SimpleDateFormat format = new SimpleDateFormat(dateformat);
//        
//        return new JsonPrimitive(format.format(src));
//      }
//    }).setDateFormat(dateformat).create();
//    if (gson != null) {
//      jsonStr = gson.toJson(ts);
//    }
//    return jsonStr;
//  }
  
  public static List<?> jsonToList(String jsonStr)
  {
    List<?> objList = null;
    if (gson != null)
    {
      Type type = new TypeToken() {}.getType();
      objList = (List)gson.fromJson(jsonStr, type);
    }
    return objList;
  }
  
  public static Map<?, ?> jsonToMap(String jsonStr)
  {
    if ((jsonStr == null) || ("".equals(jsonStr))) {
      return null;
    }
    Map<?, ?> objMap = null;
    if (gson != null)
    {
      Type type = new TypeToken() {}.getType();
      objMap = (Map)gson.fromJson(jsonStr, type);
    }
    return objMap;
  }
  
  public static <T> T jsonToBean(String jsonStr, Class<T> cl)
  {
    if ((jsonStr == null) || ("".equals(jsonStr))) {
      return null;
    }
    Object obj = null;
    if (gson != null) {
      obj = gson.fromJson(jsonStr, cl);
    }
    logger.info("");
    logger.info("-----------------------------------");
    logger.info(obj.getClass() + "  " + jsonStr);
    return (T)obj;
  }
  
//  public static <T> T jsonToBeanDateSerializer(String jsonStr, Class<T> cl, String pattern)
//  {
//    Object obj = null;
//    gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer()
//    {
//      public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
//        throws JsonParseException
//      {
//        SimpleDateFormat format = new SimpleDateFormat(this.val$pattern);
//        String dateStr = json.getAsString();
//        try
//        {
//          return format.parse(dateStr);
//        }
//        catch (ParseException e)
//        {
//          e.printStackTrace();
//        }
//        return null;
//      }
//    }).setDateFormat(pattern).create();
//    if (gson != null) {
//      obj = gson.fromJson(jsonStr, cl);
//    }
//    return (T)obj;
//  }
  
  public static Object getJsonValue(String jsonStr, String key)
  {
    Object rulsObj = null;
    Map<?, ?> rulsMap = jsonToMap(jsonStr);
    if ((rulsMap != null) && (rulsMap.size() > 0)) {
      rulsObj = rulsMap.get(key);
    }
    return rulsObj;
  }
}
