<template>   
<v-card class="cardStyle" justify="center">
      
   <v-card-title justify="center">
     <div class="titles">My reservation</div>
     <v-spacer></v-spacer>
       <v-text-field
        v-model="search"
        append-icon="mdi-magnify"      
        label="Search"
        single-line
        hide-details
        class="shrink pr-15">
      </v-text-field>
                
   </v-card-title>

    <v-data-table 
      @click:row="showBoard"
      :headers="headers"
      :items="reservationIdLists"
      :search="search"
      :page.sync="page"
      :items-per-page="itemsPerPage"
      class="table"
      hide-default-footer
      @page-count="pageCount = $event"
    ></v-data-table>

    <div class="text-center pt-2">
      <v-pagination class="grey lighten-4"
      v-model="page"
      :length="pageCount"
      ></v-pagination>
    </div>

  </v-card>
  
</template>

<script>
  export default {
    name: 'ReservationMyList',
    props: {
        reservationIdLists: {
            type: Array,
            required: true
        },  
    },
    data () {
      return {
        search: '',
        page: 1,
        pageCount: 0,
        itemsPerPage: 9,
        
        headers: [
        {text:'ReservationNo', align: 'center', value: 'reservationNo', width:'10%'}, 
        {text:'SeatNumber', align: 'center', value: 'seatNumber', width:'10%'}, 
        {text: 'Date',align: 'center', value: 'regDate',width:'15%'},
        ],
        }
      }, 
      methods: {
        showBoard(event, idx) {
          console.log("글 번호: " + idx.item.reservationNo)
          this.$router.push({name: 'ReservationCheckPage', params: {reservationNo: String(idx.item.reservationNo)}})
        },
      }
  }
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Gowun+Dodum&family=Poiret+One&family=Sunflower:wght@300&display=swap');


.table{
  cursor: pointer;
 
}
.titles{
  margin-left:40px;
  font-size: 23px;
  color:#d1a908;
  margin-right:100px;

}

.cardStyle{

  font-family: 'Poiret One', cursive;
  font-weight: bold;
  margin: 10% 10% 10% 15%;
 
  width:70%;
}
.v-data-table::v-deep th {
  font-size: 15px !important;
  font-family: 'Poiret One', cursive; 

}



</style>

