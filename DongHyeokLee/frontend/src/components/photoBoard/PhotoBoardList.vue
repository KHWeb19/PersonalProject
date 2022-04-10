<template>
    <div>
        <h3>게시물 목록</h3>
      
     <v-container>
            <v-row>
                <v-col v-for="photo in photoBoards" :key="photo.boardNo" class="d-flex child-flex" cols="4">
                    <router-link :to="{ name: 'PhotoBoardReadPage', params: { boardNo: photo.boardNo.toString() } }">
                  <v-card>
                      <div>
                        <v-img :src="require(`@/assets/uploadImg/${photo.fileName}`)" height="300"></v-img>
                      </div>

                      <v-card-title>{{photo.title}}</v-card-title>
              <v-list-item>
                <v-list-item-subtitle>
                  <strong>{{ photo.writer }}</strong>
                  <span>{{ photo.regDate.substring(0, 11) }}</span> 
                  
                  <spacer>조회 {{photo.count}} </spacer>
                  
                </v-list-item-subtitle>
              </v-list-item>
                  </v-card>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>
     <div>
   


  </div>
   
   
   
    </div>


    
</template>

<script>

export default {
    name: 'PhotoBoardList',
    props: {
      photoBoards: {
            type: Array
        }
    } 
}

</script>


<style scoped>
    
  h3 {
    margin-left: 200px;
  }  

  a{
    text-decoration: none;

  }

  a:hover{
    text-decoration: underline; 
    color: black;
    
  }

  table {
    margin-left: 180px;
    margin-top: 10px;
    margin-bottom: 10px;

    border-top: 1px solid ;
    border-collapse: collapse;
  }
  th {
    border-bottom: 1px solid ;
    border-left: 1px solid;
    padding: 10px;
  }

  td {    
    border-bottom: 1px solid;
    padding: 10px;
  }

  strong{
      margin-right: 5px;
  }

  spacer{
    margin-left:10px;
  }

  

</style>