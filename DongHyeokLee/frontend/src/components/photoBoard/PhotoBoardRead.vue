<template>
    <div >
        <div class="title">
            <h3> {{ photoBoard.title }} </h3>
            <div class="subtitle">
                <p align="center" class="writer">{{ photoBoard.writer }}</p>
                <div class="day"> 
                {{ photoBoard.regDate.substring(0, 10) }}
                {{new Date(photoBoard.regDate).
                    toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).
                        toString().substr(13, 11)}}
                </div>
            </div>
        </div>

        <div>
            <v-img class="img" :src="require(`@/assets/uploadImg/${photoBoard.fileName}`)" ></v-img>
            <table>
                <tr>
                    <td>
                    <div> {{ photoBoard.content }}</div>
                    </td>
                </tr>
            </table>
        </div>
    </div>
</template>

<script>



export default {
    name: 'PhotoBoardRead',
    props: {
        photoBoard: {
            type: Object,
            required: true
        }
    },
    components: {
       
      
    }
}
</script>

<style scoped>

.title{
    margin-left: 30%; 
    padding:15px;
    color:black;
    width:500px
}

.subtitle{
    margin-top: 10px;
}

.img {
    width: auto; 
    height: auto;
    max-width: 600px;
    max-height: 600px;
    margin-left: 30%;
    margin-bottom: 20px;
}
table {
    margin-left: 30%; 
    height: 200px;
    width: 600px;
    border: 1px solid transparent;
}
td {    
    border-bottom: 1px solid black;
    padding: 10px;
    color: black;
}
.writer{
    background-color:#EEEEEE;
    width:120px;
    font-size: 19px;
}
.day{
    border-bottom:1px solid #EEEEEE;
    width:600px;
    font-size: 17px;
    color: black;
    

}


  
</style>