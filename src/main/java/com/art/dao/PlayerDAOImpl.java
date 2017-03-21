package com.art.dao;

import com.art.character.Heroes.Mage;
import com.art.character.Heroes.Player;
import com.art.character.Heroes.Rogue;
import com.art.character.Heroes.Warrior;
import com.art.model.Item;
import com.art.model.User;
import com.art.model.Userdetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("PlayerDao")
public class PlayerDAOImpl implements PlayerDAO {
    @Autowired
    private  UserDetailsDAO userDetailsDAO;

    @Autowired
    private  ItemDAO itemDAO;

    @Override
    public Player getPlayer(String type, String login, Userdetails userdetails) {
        Player player;
        if (type.equals("Warrior")) {
            player = new Warrior(login);

        } else if (type.equals("Rogue")) {
            player = new Rogue(login);

        } else if (type.equals("Mage")) {
            player = new Mage(login);

        } else {
            player = null;
            ;
            ;

        }
        if (userdetails.getAgility() != 0) player.setAgility(userdetails.getAgility());
        if (userdetails.getStrenght() != 0) player.setStrength(userdetails.getStrenght());
        if (userdetails.getIntelligence() != 0) player.setIntelligence(userdetails.getIntelligence());
        if (userdetails.getVitality() != 0) player.setVitality(userdetails.getVitality());
        if (userdetails.getExp() != 0) player.setExp(userdetails.getExp());
        player.setLevel(userdetails.getLevel());
        player.setPoint(userdetails.getPoint());
        try {
            String[] split = userdetails.getWearingItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);
                player.addItem(item);

            }
            ;
        } catch (Exception ex) {

        }
        try {
            String[] split = userdetails.getItems().split(",");
            for (String s : split) {
                int id = new Integer(s);
                Item item = itemDAO.findById(id);
                player.equip(item);
                ;
                ;
            }
            ;
        } catch (NullPointerException ex) {
        }

        player.calculateItem(userdetails.getItems(), userdetails.getWearingItems());
        player.calculateAttack();
        player.calculateHealth();
        player.calculateMana();
        player.calculateDefense();
        return player;
    }

    @Override
    public String getWearitem(Player player) {
        String s = "";
        try {
            for (Item item : player.getWearItem()) {
                if (item != null) {
                    if (s.equals("")) s += item.getId();
                    else
                        s = s + "," + item.getId();
                }
            }
        } catch (Exception ex) {
        }
        if (s.isEmpty()) s = null;
        return s;
    }

    @Override
    public String getItemList(Player player) {
        String s = "";
        try {
            for (Item item : player.getItemList()) {
                if (item != null) {
                    if (s.equals("")) s += item.getId();
                    else
                        s = s + "," + item.getId();
                }
            }
        } catch (Exception ex) {
        }
        if (s.isEmpty()) s = null;
        return s;
    }

    @Override
    public List<Item> getWearItem(Player player) {
        List<Item> itemList = new ArrayList<>();
        for (Item item : player.getWearItem()) {
            if (item != null) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    @Override
    public List<Item> getItem(Player player) {
        List<Item> itemList = new ArrayList<>();
        for (Item item : player.getItemList()) {
            if (item != null) {
                itemList.add(item);
            }
        }
        return itemList;
    }

    @Override
    public String setItem(User user, int id) {
        String items = user.getUserdetails().getItems();
        try {
            if (items!=null) {
            items = items + "," + Integer.toString(id); }
            else {
                items = Integer.toString(id);
            }
        } catch (NullPointerException ex) {
            items = Integer.toString(id);
        }
        return items;
    }

    @Override
    public Player deleteItem(Player player, User user, int id) {
        player.deleteItem(itemDAO.findById(id));
        String s = getItemList(player);
        user.getUserdetails().setItems(s);
        userDetailsDAO.update(user.getUserdetails());
        return  player;
    }

    @Override
    public Player unequipe(Player player, User user, int id) {
        Item item1 = itemDAO.findById(id);
        if (item1==null) return player;
        player.unequip(item1);
        String s = getWearitem(player);
        user.getUserdetails().setWearingItems(s);
        String items = setItem(user, id);
        user.getUserdetails().setItems(items);
        userDetailsDAO.update(user.getUserdetails());
        return  player;

    }

    @Override
    public Player deleteEquipeItem(Player player, User user, int id) {
        Item item = itemDAO.findById(id);
        if (item==null) return player;
        player.unequip(item);
        String s = getWearitem(player);
        user.getUserdetails().setWearingItems(s);
        player.deleteItem(item);
        s = getItemList(player);
        userDetailsDAO.update(user.getUserdetails());
        return  player;
    }

    @Override
    public Player equip(Player player, User user, int id) {
        Item item = itemDAO.findById(id);
        if (item==null) return player;
        Item[] wearItem = player.getWearItem();
        if (wearItem[item.getPosition()]!=null) {
         player = unequipe(player,user,wearItem[item.getPosition()].getId());
        }
        player.addItem(item);
        String s = getWearitem(player);
        user.getUserdetails().setWearingItems(s);
         s = getItemList(player);
        user.getUserdetails().setItems(s);
        userDetailsDAO.update(user.getUserdetails());
        return  player;
    }
}
