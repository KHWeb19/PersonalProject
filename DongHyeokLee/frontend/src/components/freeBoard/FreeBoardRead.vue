<template>
    <div>
        <div class="title">
            <h3>{{ freeBoard.title }}</h3>
            <div class="subtitle">
                <p class="writer">{{ freeBoard.writer }} </p>
                <span class="day"><strong> {{ freeBoard.regDate.substring(0, 10) }} 
                    {{new Date(freeBoard.regDate).toLocaleString("ko-KR", {timeZone: "Asia/Seoul"}).toString().substr(12, 8)}}
                    </strong>
                </span>   
            </div>
        </div>

        <table>
            <tr>
                <td>
                    {{ freeBoard.content }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>



export default {
    name: 'FreeBoardRead',
    props: {
        freeBoard: {
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
    color:white;
    width:500px
}
.subtitle{
    margin-top: 10px;
}
td {    
    border-top: 3px solid white;
    border-bottom: 3px solid white;
    padding: 10px;
    color: white;
}
table{
    margin-left: 30%; 
    height: 500px;
    width: 600px;
    border: 1px solid transparent;
}
.day {
    font-size: 17px;
    color: grey;
}

    
  
</style>