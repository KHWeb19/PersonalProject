<template>
    <div>
        <h3>게시물 목록</h3>
      
     <v-container>
            <v-row>
                <v-col v-for="video in videoBoards" :key="video.boardNo" class="d-flex child-flex" cols="4">
                    <router-link :to="{ name: 'VideoBoardReadPage', params: { boardNo: video.boardNo.toString() } }">
                  <v-card>
                      <div>
                        <!-- 파일말고 링크 가지고 오고싶은데 어케하노-->
                        <iframe :src="require(`@/assets/uploadVideo/${video.fileName}`)" height="300" width="100%" 
                        allow="autoplay muted;"></iframe>
                      </div>

                      <v-card-title>{{video.title}}</v-card-title>
              <v-list-item>
                <v-list-item-subtitle>
                  <strong>{{ video.writer }}</strong>
                  <span>{{ video.regDate.substring(0, 11) }}</span>
                </v-list-item-subtitle>
              </v-list-item>
                  </v-card>
                    </router-link>
                </v-col>
            </v-row>
        </v-container>

  </div>


    
</template>

<script>

export default {
    name: 'VideoBoardList',
    props: {
      videoBoards: {
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

  

</style>