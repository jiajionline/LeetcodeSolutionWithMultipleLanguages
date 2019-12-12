import java.util.ArrayList;
import java.util.LinkedList;

class StockSpanner {

    private ArrayList<Integer> _priceList;
    private ArrayList<Integer> _dp;

    public StockSpanner() {
        _priceList = new ArrayList();
        _dp = new ArrayList();
    }
    
    public int next(int price) {
        if(_priceList.isEmpty() || price < _priceList.get(_priceList.size()-1)){
            _dp.add(1);
        }else{
            int loopBack = _priceList.size()-1;
            while(loopBack >=0 && price >= _priceList.get(loopBack) ){
                loopBack -= _dp.get(loopBack);
            }
            _dp.add(_priceList.size() - loopBack);
        }

        _priceList.add(price);

        return _dp.get(_dp.size()-1);
    }
}
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */