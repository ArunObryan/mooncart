#
# ***************************************************
# ********* Docker file for MYSQL Database **********
# ***************************************************

#Image name to be pulled from docker repository
ARG DB_BASE_IMAGE
FROM ${DB_BASE_IMAGE}

#Set the DB name
ARG DATABASE_NAME
ENV MYSQL_DATABASE ${DATABASE_NAME}

#Get the DB password and set it to the root user
ARG DB_PASSWORD
ENV MYSQL_ROOT_PASSWORD ${DB_PASSWORD}

#Add the content of the ddl-scripts/ directory to your image
#All scripts in docker-entrypoint-initdb.d/ are automatically executed during container start up
#Enable the below line before adding any scripts
#COPY ./scripts/ /docker-entrypoint-initdb.d/