<template>
<div id="app">
  <v-app id="inspire">
    <v-container style="width:800px" justify="center">
    <v-card>
      <v-card-title>
        Nutrition
        <v-spacer></v-spacer>
        <v-text-field
          v-model="search"
          label="Search"
          single-line
          hide-details
        ></v-text-field>
            <v-col cols="2" md="1">
                <v-btn id="searchBtn" dark small>
                    <v-icon>
                        mdi-magnify
                    </v-icon>
                </v-btn>
            </v-col>
      </v-card-title>
      <v-data-table
        :headers="headers"
        :items="desserts"
        :search="search"
      >
        <template v-slot:items="props">
          <td>{{ props.item.name }}</td>
          <td class="text-xs-right">{{ props.item.plastic }}</td>
          <td class="text-xs-right">{{ props.item.glass}}</td>
          <td class="text-xs-right">{{ props.item.vinyl }}</td>
          <td class="text-xs-right">{{ props.item.paper }}</td>
          <td class="text-xs-right">{{ props.item.can }}</td>
        </template>
        <template v-slot:no-results>
          <v-alert :value="true" color="error" icon="warning">
            Your search for "{{ search }}" found no results.
          </v-alert>
        </template>
      </v-data-table>
    </v-card>
    </v-container>
  </v-app>
</div>
</template>

<script>
export default {
    name: "guideSearchForm.vue",
  data () {
    return {
      search: '',
      headers: [
        {
          text: '상품명',
          align: 'left',
          sortable: false,
          width: '200px',
          value: 'name'
        },
        { text: '플라스틱', value: 'plastic', sortable: false, width: '70px' },
        { text: '유리', value: 'glass', sortable: false, width: '60px' },
        { text: '비닐', value: 'vinyl', sortable: false, width: '60px' },
        { text: '종이', value: 'paper', sortable: false, width: '60px' },
        { text: '캔', value: 'can', sortable: false, width: '60px' }
      ],
      desserts: [
        {
          name: 'Frozen Yogurt',
          calories: 159,
          fat: 6.0,
          carbs: 24,
          protein: 4.0,
          iron: '1%'
        },
        {
          name: '감자튀김',
          calories: 237,
          fat: 9.0,
          carbs: 37,
          protein: 4.3,
          iron: '1%'
        },
        {
          name: 'Eclair',
          calories: 262,
          fat: 16.0,
          carbs: 23,
          protein: 6.0,
          iron: '7%'
        },
        {
          name: 'Cupcake',
          calories: 305,
          fat: 3.7,
          carbs: 67,
          protein: 4.3,
          iron: '8%'
        },
        {
          name: 'Gingerbread',
          calories: 356,
          fat: 16.0,
          carbs: 49,
          protein: 3.9,
          iron: '16%'
        },
        {
          name: 'Jelly bean',
          calories: 375,
          fat: 0.0,
          carbs: 94,
          protein: 0.0,
          iron: '0%'
        },
        {
          name: 'Lollipop',
          calories: 392,
          fat: 0.2,
          carbs: 98,
          protein: 0,
          iron: '2%'
        },
        {
          name: 'Honeycomb',
          calories: 408,
          fat: 3.2,
          carbs: 87,
          protein: 6.5,
          iron: '45%'
        },
        {
          name: 'Donut',
          calories: 452,
          fat: 25.0,
          carbs: 51,
          protein: 4.9,
          iron: '22%'
        },
        {
          name: 'KitKat',
          calories: 518,
          fat: 26.0,
          carbs: 65,
          protein: 7,
          iron: '6%'
        }
      ]
    }
  }
}
</script>

<style scoped>
.v-text-field >>> .v-input__slot::before  { 
  border-color: #ccbce3 !important;
  }
.v-text-field >>> .v-input__slot::after {
    border-color: #ccbce3 !important;
    }
    /* ↓안되네... */
.tr:hover{ 
    background-color: red;
}
.td {
  margin: 20px;
}
.btn-cover {
  margin-top: 1.5rem;
  text-align: center;
}
.btn-cover .page-btn {
  width: 5rem;
  height: 2rem;
  letter-spacing: 0.5px;
}
.btn-cover .page-count {
  padding: 0 1rem;
}

#searchBtn {
    background-color: darkkhaki;
    box-shadow: none;
}
</style>