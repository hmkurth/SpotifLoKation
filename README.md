# Extending Spotify's API

## Problem Statement
The goal is to associate Spotify artists with a geolocation. The current Spotify API does not provide the location for their artist data. This application seeks to crowdsource this information and provide an API service for artist location information.  

## Project Objectives
MVP: 
* Front end form for collecting data
  * Artist
  * Location (String)
* Persistant storage in MySQL db
* REST Service for serving back data
* Documentation + Presentation Materials

## Project Plan
* Front End Form
    * Accepts an Aritst Id
    * Verify Artist ID + confirm Artist Name wih User
    * Check if that Artist exists in the DB already and if so display the existing location data.
    * Add new or edit Artist location
    * Admin controls - V.Next
* Artist Information
    * Store Id + Name - MVP
    * Consume full Spotify artist info - V.Next
* Location Information
    * City-level granularity
    * String - MVP 
    * Lat/Lng - V.Next
* Persist collected information
    * DB table
    * ARTIST:  | id | artistName | locationId |
    * LOCATION:  | id | country | region | city |
* API Services Used
  * Spotify
  * TBD
* Deploy to AWS


| Week | Objectives | Assignee | Notes| Accomplished |
|------|------|-------|------|------|
| 1 | Project Planning |Everyone| | Y |
| 1 | Set Git Repo| SL | {git location here} | Y |
| 1 | Main Package Dir./ Local deployment | HK | | Y |
| 1 | Local MySQL Db Set Up | HK | Commit script in project folder | y|
| 1 | Configure Hibernate | HK | hibernate.cfg.xml added to main and test| |
| 1 | DAO | KH | | Y|
| 1 | Entities | KH | |Y|
| 1 | Tests - CRUD | SL | | Y|
| 1 | Basic JSPs + Controllers | SL | | Y |
| 2 | Consume Spotify API / Logic | SL |Happy Path is okay, considering error handling/ messaging |Y|
| 2 | REST Service - Hard Coded | KH | | |
| 2 | REST Service - Live Data | SL/KH | | |
| 2 | Deploy to AWS | HK | Wait on application flow | y|
| 3 | Error handling - front end | | | |
| 3 | Error handling - service | | | | 
| 3 | Bootstrap / CSS styling | hk| | |
| 3 | Project Documentation | | | i (HK)have done some looking into this... Swagger IO|
| 3 | Presentation Prep | ALL | | |

